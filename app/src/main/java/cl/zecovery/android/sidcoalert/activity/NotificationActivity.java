package cl.zecovery.android.sidcoalert.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import cl.zecovery.android.sidcoalert.R;

public class NotificationActivity extends AppCompatActivity {

    private static final String LOG_TAG = NotificationActivity.class.getName();

    private String alertNumber;
    private String alertUser;
    private String alertRegion;
    private String alertInit;
    private String alertStop;
    private String alertDeltaTime;
    private String alertDeltaQuery;
    private String alertDownload;
    private String alertSize;
    private String alertTiempoT;

    private TextView textViewNumber;

    private TextView textViewUser;
    private TextView textViewRegion;
    private TextView textViewInit;
    private TextView textViewStop;
    private TextView textViewDeltaTime;
    private TextView textViewDeltaQuery;
    private TextView textViewDownload;
    private TextView textViewSize;
    private TextView textViewTransfTime;

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        alertNumber = getIntent().getStringExtra("alert_number");
        alertUser = getIntent().getStringExtra("alert_user");
        alertRegion = getIntent().getStringExtra("alert_region");
        alertInit = getIntent().getStringExtra("alert_init");
        alertStop = getIntent().getStringExtra("alert_stop");
        alertDeltaTime = getIntent().getStringExtra("alert_delta_time");
        alertDeltaQuery = getIntent().getStringExtra("alert_delta_query");
        alertDownload = getIntent().getStringExtra("alert_download");
        alertSize = getIntent().getStringExtra("alert_size");
        alertTiempoT = getIntent().getStringExtra("alert_tiempo_t");

        Log.d(LOG_TAG, "alertNumber: " + alertNumber);
        Log.d(LOG_TAG, "alertUser: " + alertUser);
        Log.d(LOG_TAG, "alertRegion: " + alertRegion);
        Log.d(LOG_TAG, "alertInit: " + alertInit);
        Log.d(LOG_TAG, "alertStop: " + alertStop);
        Log.d(LOG_TAG, "alertDeltaTime: " + alertDeltaTime);
        Log.d(LOG_TAG, "alertDeltaQuery: " + alertDeltaQuery);
        Log.d(LOG_TAG, "alertDownload: " + alertDownload);
        Log.d(LOG_TAG, "alertSize: " + alertSize);
        Log.d(LOG_TAG, "alertTiempoT: " + alertTiempoT);

        textViewNumber = (TextView) findViewById(R.id.textViewNumber);
        textViewUser = (TextView) findViewById(R.id.textViewUser);
        textViewRegion = (TextView) findViewById(R.id.textViewRegion);
        textViewInit = (TextView) findViewById(R.id.textViewInit);
        textViewStop = (TextView) findViewById(R.id.textViewStop);
        textViewDeltaTime = (TextView) findViewById(R.id.textViewDeltaTime);
        textViewDeltaQuery = (TextView) findViewById(R.id.textViewDeltaQuery);
        textViewDownload = (TextView) findViewById(R.id.textViewDeltaDownload);
        textViewSize = (TextView) findViewById(R.id.textViewSize);
        textViewTransfTime = (TextView) findViewById(R.id.textViewTransTime);


        lineChart = (LineChart) findViewById(R.id.lineChart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));

        ArrayList<String> labels = new ArrayList<>();
        labels.add("1");
        labels.add("2");
        labels.add("3");
        labels.add("4");
        labels.add("5");
        labels.add("6");

        LineData data = new LineData();

        lineChart.setData(data); // set the data and list of lables into chart
        lineChart.setDescription("Description");  // set the description

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();

        textViewNumber.setText(alertNumber);
        textViewUser.setText(alertUser);
        textViewRegion.setText(alertRegion);
        textViewInit.setText(alertInit);
        textViewStop.setText(alertStop);
        textViewDeltaTime.setText(alertDeltaTime);
        textViewDeltaQuery.setText(alertDeltaQuery);
        textViewDownload.setText(alertDownload);
        textViewSize.setText(alertSize);
        textViewTransfTime.setText(alertTiempoT);
    }
}
