package sbl.com.piechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import sbl.com.piechart.datamodel.PieChartData;

public class MainActivity extends AppCompatActivity {

    private PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mChart = (PieChart) findViewById(R.id.chart1);
        populateChart();
    }

    private void populateChart() {
        ArrayList<PieChartData> list = new ArrayList<PieChartData>();
        list.add( new PieChartData("English", 30f, PieChartData.COLOR_RED));
        list.add( new PieChartData("Malayalam", 45f, PieChartData.DEEP_PURPLE));
        list.add( new PieChartData("Hindi", 25f, PieChartData.GREEN));
        drawChart(mChart, "Films", list, true);
    }

    private void drawChart(PieChart chart,String chartName,
                           ArrayList<PieChartData> objects,
                           boolean animate) {
        if( chart == null || objects == null) return;
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for( PieChartData object : objects) {
            entries.add(new PieEntry(object.value, object.label));
            colors.add(object.color);
        }
        PieDataSet dataSet = new PieDataSet(entries, chartName);
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);


        //Set Chart description
        Description description = new Description();
        description.setText("Sample Description");
        chart.setDescription(description);



        chart.setData(data);
        chart.invalidate();

        if(animate) {
            chart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        }

        Legend legend = chart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setTextSize(11f);
        legend.setXEntrySpace(7f);
        legend.setYEntrySpace(0f);
        legend.setYOffset(0f);
    }
}
