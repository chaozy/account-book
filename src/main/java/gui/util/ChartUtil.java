package gui.util;
/**
 * ChartUtil is a tool class used to draw a line chart using JFreeChart
 * The method getImage() returns the image of the line chart
 */

import service.AnalysisService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class ChartUtil {
    private JFreeChart lineChart;
    public ChartUtil(String title) {
        double[] data = new AnalysisService().listSpendThisMonth();
        lineChart = ChartFactory.createXYLineChart(title, "DATE", "EXPENSE",
                getDataset(data), PlotOrientation.VERTICAL, true, true, false);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint(0 , Color.BLUE );

        NumberAxis xAxis = new NumberAxis();
        xAxis.setTickUnit(new NumberTickUnit(5));
        XYPlot plot = lineChart.getXYPlot();
        plot.setDomainAxis(xAxis);
    }

    private XYDataset getDataset(double[] data){
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("EXPENSE");
        for (int i = 0; i < data.length; i++) {
            series.add(i + 1, data[i]);
        }
        //Add series to dataset
        dataset.addSeries(series);
        return dataset;
    }

    private static double[] sampleValues() {
        double[] result = new double[30];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;
    }

    public Image getImage(int wid, int hei){
        Image image = lineChart.createBufferedImage(wid, hei);
        return image;
    }

    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        ChartUtil chart = new ChartUtil("TEST");
        Image img = chart.getImage(300, 300);
        Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUtil.showPanel(p);
    }
}
