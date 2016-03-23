package cl.zecovery.android.sidcoalert.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cl.zecovery.android.sidcoalert.R;
import cl.zecovery.android.sidcoalert.main.Alert;

/**
 * Created by fran on 10-03-16.
 */
public class AlertAdapter extends ArrayAdapter<Alert> {

    public AlertAdapter(Context context, ArrayList<Alert> alerts) {
        super(context, 0, alerts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Alert alert = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_listview, parent, false);
        }

        TextView textViewNumber = (TextView) convertView.findViewById(R.id.textViewNumber);
        TextView textViewTransTime = (TextView) convertView.findViewById(R.id.textViewTransTime);
        TextView textViewRegion = (TextView) convertView.findViewById(R.id.textViewRegion);

        textViewNumber.setText(alert.number);
        textViewTransTime.setText(alert.trasnfTime);
        textViewRegion.setText(alert.region);

        if (Integer.valueOf(alert.number) == 5) {

            textViewTransTime.setBackgroundColor(Color.parseColor("#FF0000"));
        }

        return convertView;
    }
}
