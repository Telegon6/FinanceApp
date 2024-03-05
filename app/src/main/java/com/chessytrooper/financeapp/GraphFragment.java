package com.chessytrooper.financeapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphFragment extends Fragment {

    private LineChart lineChart;
    private CombinedChart mChart;
    private Float selectedYIndex = null;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_graph, container, false);
        textView = getActivity().findViewById(R.id.textView7);

        //lineChart = view.findViewById(R.id.line_chart);

        mChart = view.findViewById(R.id.line_chart);
        mChart.getDescription().setText("This is testing Description");
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(true);
        mChart.setDrawBarShadow(false);
        mChart.setHighlightFullBarEnabled(false);

        // draw bars behind lines
        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR,  CombinedChart.DrawOrder.LINE
        });


        /*LineDataSet lineDataSet = new LineDataSet(dataValues(), "entries");
        lineDataSet.setLineWidth(6);
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "$" + value;
            }
        });
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);

        String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July",
                "Aug", "Sept", "Oct", "Nov", "Dec"}; */

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(false);
        xAxis.enableGridDashedLine(6, 12, 0);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(mMonths));


        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        CombinedData data = new CombinedData();

        data.setData(generateBarData());
        data.setData( generateLineData());

        mChart.setData(data);
        mChart.setDescription(description);
        mChart.getXAxis().setAxisMinimum(-0.25f);
        mChart.getXAxis().setAxisMaximum(data.getXMax() + 0.25f);
        mChart.setScrollX(2);
        mChart.zoom(1.7f,0,1,1);
        mChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

                mChart.getHighlightByTouchPoint(me.getX(), me.getY()).getY();
                List<IBarDataSet> barDataSets = mChart.getBarData().getDataSets();
                for (IBarDataSet barDataSet : barDataSets) {
                    BarDataSet barDataSet1 = (BarDataSet) barDataSet;
                    barDataSet1.setColor(Color.GREEN);
                    Log.i("iMessage", String.valueOf(barDataSet1));
                }
            }
            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                if (e instanceof BarEntry) {
                    // The entry is a BarEntry
                    BarEntry entry = (BarEntry) e;
                    // The y value of the entry
                    float y = entry.getY();
                    Log.d("Dodo", String.valueOf(y));
                    if (textView != null) {
                        textView.setText(String.valueOf(y));
                    } else {
                        Log.d("Dodo", "TextView is null");
                    }

                } else {
                    // The entry is not a BarEntry
                    Log.d("Dodo", "The entry is not a BarEntry");
                }
            }


            @Override
            public void onNothingSelected() {

            }
        });
        mChart.invalidate();


        return view;
    }
    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "June"
    };

    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<Entry>();

        entries = getLineEntriesData(entries);

        LineDataSet set = new LineDataSet(entries, "Line");
        //set.setColor(Color.rgb(240, 238, 70));
        set.setColors(ColorTemplate.COLORFUL_COLORS);
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return d;
    }

    private ArrayList<Entry> getLineEntriesData(ArrayList<Entry> entries){
        entries.add(new Entry(0, 5));
        entries.add(new Entry(1, 20));
        entries.add(new Entry(2, 10));
        entries.add(new Entry(3, 8));
        entries.add(new Entry(4, 40));
        entries.add(new Entry(5, 37));

        return entries;
    }

    private BarData generateBarData() {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        entries = getBarEnteries(entries);

        BarDataSet set1 = new BarDataSet(entries, "Bar");
        //set1.setColor(Color.rgb(60, 220, 78));
        set1.setColors(Color.TRANSPARENT);
        //set1.setValueTextColor(Color.rgb(60, 220, 78));
        //set1.setValueTextSize(10f);
        set1.setBarBorderColor(Color.BLACK);
        set1.setHighLightColor(Color.BLUE);
        //set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        float barWidth = 0.45f; // x2 dataset


        BarData d = new BarData(set1);
        d.setBarWidth(barWidth);


        return d;
    }

    private ArrayList<BarEntry> getBarEnteries(ArrayList<BarEntry> entries){
        entries.add(new BarEntry(0, 45));
        entries.add(new BarEntry(1, 25));
        entries.add(new BarEntry(2, 30));
        entries.add(new BarEntry(3, 38));
        entries.add(new BarEntry(4, 10));
        entries.add(new BarEntry(5, 15));
        return  entries;
    }
}