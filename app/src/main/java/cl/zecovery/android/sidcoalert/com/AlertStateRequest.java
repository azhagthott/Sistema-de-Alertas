package cl.zecovery.android.sidcoalert.com;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cl.zecovery.android.sidcoalert.adapter.AlertAdapter;
import cl.zecovery.android.sidcoalert.main.Alert;

/**
 * Created by fran on 07-01-16.
 */
public class AlertStateRequest {

    private static final String LOG_TAG = AlertStateRequest.class.getName();

    private Context mContext;

    private JSONObject jsonObject;
    private JSONObject contextElement;
    private JSONArray jsonArray;
    private JSONObject element;

    public List<String> result;

    public AlertStateRequest() {
    }

    public AlertStateRequest(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void getDataForListView(AlertAdapter adapter) {

        adapter.clear();

        try {
            jsonArray = jsonObject.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {

                Alert alert = new Alert();

                JSONObject data = jsonArray.getJSONObject(i);
                String data_id = data.getString("data_id");

                JSONArray dataContent = data.getJSONArray("data_content");

                for (int j = 0; j < dataContent.length(); j++) {

                    JSONObject content = dataContent.getJSONObject(j);

                    String numero = content.getString("numero");
                    String usuario = content.getString("usuario");
                    String region = content.getString("region");
                    String inicio = content.getString("inicio");
                    String termino = content.getString("termino");
                    String delta = content.getString("delta");
                    String delta_query = content.getString("delta_query");
                    String delta_descarga = content.getString("delta_descarga");
                    String size = content.getString("size");
                    String tiempo_t = content.getString("tiempo_t");

                    alert.setNumber(numero);
                    alert.setUser(usuario);
                    alert.setRegion(region);
                    alert.setInit(inicio);
                    alert.setStop(termino);
                    alert.setDeltaTime(delta);
                    alert.setDeltaQuery(delta_query);
                    alert.setDeltaDownload(delta_descarga);
                    alert.setSize(size);
                    alert.setTrasnfTime(tiempo_t);

                }
                adapter.addAll(alert);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isNetworkAvailable(Context context) {
        mContext = context;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}