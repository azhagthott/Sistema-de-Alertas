package cl.zecovery.android.sidcoalert.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import cl.zecovery.android.sidcoalert.R;
import cl.zecovery.android.sidcoalert.adapter.AlertAdapter;
import cl.zecovery.android.sidcoalert.animation.UIAnimation;
import cl.zecovery.android.sidcoalert.com.AlertStateRequest;
import cl.zecovery.android.sidcoalert.com.CustomJsonRequest;
import cl.zecovery.android.sidcoalert.constant.Constant;
import cl.zecovery.android.sidcoalert.main.Alert;
import cl.zecovery.android.sidcoalert.notification.DisplayNotification;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    private String url;
    private CustomJsonRequest request;
    private AlertAdapter adapter;
    private AlertStateRequest notification;
    private UIAnimation animation;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        notification = new AlertStateRequest();

        ArrayList<Alert> arrayList = new ArrayList<>();
        adapter = new AlertAdapter(getApplicationContext(), arrayList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), NotificationActivity.class);

                Alert alertDetail = adapter.getItem(position);

                i.putExtra("alert_number", alertDetail.getNumber());
                i.putExtra("alert_user", alertDetail.getUser());
                i.putExtra("alert_region", alertDetail.getRegion());
                i.putExtra("alert_init", alertDetail.getInit());
                i.putExtra("alert_stop", alertDetail.getStop());
                i.putExtra("alert_delta_time", alertDetail.getDeltaTime());
                i.putExtra("alert_delta_query", alertDetail.getDeltaQuery());
                i.putExtra("alert_download", alertDetail.getDeltaDownload());
                i.putExtra("alert_size", alertDetail.getSize());
                i.putExtra("alert_tiempo_t", alertDetail.getTrasnfTime());

                startActivity(i);
            }
        });

        animation = new UIAnimation();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.clear();

                DisplayNotification notification = new DisplayNotification();
                notification.sendSimpleNotification(getApplicationContext());

                downloadData();

                animation.animateFAB(getApplicationContext(), fab);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        downloadData();
    }

    private void downloadData() {
        if (notification.isNetworkAvailable(getApplicationContext())) {
            url = Constant.URL + "all";

            request = new CustomJsonRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            notification = new AlertStateRequest(jsonObject);
                            notification.getDataForListView(adapter);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(LOG_TAG, "ERROR:::: " + error);
                            error.printStackTrace();
                        }
                    }
            );
            request.setPriority(Request.Priority.HIGH);
            Volley.newRequestQueue(getApplicationContext()).add(request);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_graph) {
            Intent i = new Intent(MainActivity.this, ChartsActivity.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_about) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
