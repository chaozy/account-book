package gui.listener;

import gui.MainPanel;
import gui.panel.*;
import gui.panel.ConfigPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainPanel = MainPanel.getInstance();
        JButton button = (JButton)e.getSource();
        if (button == mainPanel.bReport)
            mainPanel.getPanel().display(AnalysisPanel.getInstance());
        if (button == mainPanel.bCategory)
            mainPanel.getPanel().display(CategoryPanel.getInstance());
        if (button == mainPanel.bSpend)
            mainPanel.getPanel().display(ExpensePanel.getInstance());
        if (button == mainPanel.bRecord)
            mainPanel.getPanel().display(RecordPanel.getInstance());
        if (button == mainPanel.bConfig)
            mainPanel.getPanel().display(ConfigPanel.getInstance());
        if (button == mainPanel.bConnection)
            mainPanel.getPanel().display(ConnectionPanel.getInstance());
//        if (button == mainPanel.bRecover)
//            mainPanel.getPanel().display(RecoverPanel.instance);

    }
}
