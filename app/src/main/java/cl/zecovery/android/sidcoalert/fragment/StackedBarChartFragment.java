package cl.zecovery.android.sidcoalert.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import cl.zecovery.android.sidcoalert.R;

public class StackedBarChartFragment extends Fragment {

    private BarChart mChart;
    private View rootView;

    public StackedBarChartFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_stacked_bar_chart, container, false);

        mChart = (BarChart) rootView.findViewById(R.id.barChart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));
        entries.add(new BarEntry(6f, 6));
        entries.add(new BarEntry(12f, 7));
        entries.add(new BarEntry(18f, 8));
        entries.add(new BarEntry(9f, 9));
        entries.add(new BarEntry(8f, 10));
        entries.add(new BarEntry(6f, 11));
        entries.add(new BarEntry(12f, 12));
        entries.add(new BarEntry(18f, 13));
        entries.add(new BarEntry(9f, 14));

        ArrayList<String> labelsRegion = new ArrayList<>();
        labelsRegion.add("I");
        labelsRegion.add("II");
        labelsRegion.add("III");
        labelsRegion.add("IV");
        labelsRegion.add("V");
        labelsRegion.add("VI");
        labelsRegion.add("VII");
        labelsRegion.add("VIII");
        labelsRegion.add("IX");
        labelsRegion.add("X");
        labelsRegion.add("XI");
        labelsRegion.add("XII");
        labelsRegion.add("RM");
        labelsRegion.add("XIV");
        labelsRegion.add("XV");

        BarDataSet dataset = new BarDataSet(entries, "# Alertas por region");
        dataset.setColors(ColorTemplate.LIBERTY_COLORS);

        BarData data = new BarData(labelsRegion, dataset);
        mChart.setData(data);

        mChart.animateY(1500);

        return rootView;
    }
}
