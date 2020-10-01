package gui.panel;

import gui.util.ChartUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class AnalysisPanel extends WorkingPanel {

    private static AnalysisPanel instance = new AnalysisPanel();
    public static AnalysisPanel getInstance() { return instance; }

    private JLabel label = new JLabel();

    public AnalysisPanel() {
        this.setLayout(new BorderLayout());
        this.add(label);
    }


    @Override
    public void addListener() { }

    @Override
    public void updatePanel() {
        ChartUtil chart = new ChartUtil("AnalysisPanel");
        Image i = chart.getImage(400, 400);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
    }
}

