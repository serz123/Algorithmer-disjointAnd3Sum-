package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import unionfind.UnionFindMeasuring;
import wqunionfind.WQUnionFindMeasuring;

import javax.swing.*;
import java.awt.*;

public class ChartSeveralFinds extends JFrame {
  UnionFindMeasuring unionFindMeasuring = new UnionFindMeasuring();
  WQUnionFindMeasuring wqUnionFindMeasuring = new WQUnionFindMeasuring();

  public ChartSeveralFinds (String title) {
    super(title);

    // Create a dataset
    XYSeriesCollection dataset = createDataset();

    // Create a chart based on the dataset
    JFreeChart chart = ChartFactory.createXYLineChart(
            "Several Finds",
            "Number of elements in the list",
            "Time (ns)",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
    );

    // Customize the chart
    chart.setBackgroundPaint(Color.white);

    // Create a panel to display the chart
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new Dimension(800, 600));
    setContentPane(chartPanel);
  }

  private XYSeriesCollection createDataset() {
    XYSeriesCollection dataset = new XYSeriesCollection();
    int[] listSizes = generateRepetitionSizes(1000);

    XYSeries series1 = new XYSeries("UnionFind Operation");
    XYSeries series2 = new XYSeries("WQUnionFind Operation");

    for (int i = 10; i < listSizes.length; i++) {
      long timeuf = unionFindMeasuring.measureFewFinds(100,5, 6, i);
      long timewquf = wqUnionFindMeasuring.measureFewFinds(100,5, 6, i);
      series1.add(i, timeuf);
      series2.add(i, timewquf);
    }

    dataset.addSeries(series1);
    dataset.addSeries(series2);

    return dataset;
  }

  private int[] generateRepetitionSizes(int numElements) {
    int[] list = new int[numElements];
    for (int i = 0; i < list.length; i++) {
      list[i] = i;
    }
    return list;
  }
}
