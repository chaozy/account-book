package gui;
/**
 * Main panel, contains the toolbar and nothing else
 */

import gui.listener.ToolBarListener;
import gui.util.CentralPanel;
import gui.util.GUIUtil;
import util.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainPanel extends JPanel {

    // The currently displaying panel
    private CentralPanel displayPanel = null;

    private static MainPanel instance = new MainPanel();
    public static MainPanel getInstance() { return instance; }

    public JToolBar topBar = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bConnection = new JButton();
    public JButton bRecover = new JButton();

    private MainPanel() {
         File file = new File("img/home.png");
        GUIUtil.setImageIcon(bSpend, Constant.RESOURCES_PATH + "img/home.png", "EXPENSES");
        GUIUtil.setImageIcon(bRecord, Constant.RESOURCES_PATH + "img/record.png", "RECORD");
        GUIUtil.setImageIcon(bCategory, Constant.RESOURCES_PATH + "img/category2.png", "CATEGORY");
        GUIUtil.setImageIcon(bReport, Constant.RESOURCES_PATH + "img/report.png", "MONTH REPORT");
        GUIUtil.setImageIcon(bConfig, Constant.RESOURCES_PATH + "img/config.png", "CONFIG");
//        GUIUtil.setImageIcon(bConnection, "img/backup.png", "Connection");
//        GUIUtil.setImageIcon(bRecover, "img/restore.png", "RESTORE");

        topBar.add(bSpend);
        topBar.add(bRecord);
        topBar.add(bCategory);
        topBar.add(bReport);
        topBar.add(bConfig);
        topBar.add(bConnection);
//        topBar.add(bRecover);
        topBar.setFloatable(false); // true for the user to move the tool bar.

        displayPanel = new CentralPanel(0.8);
        setLayout(new BorderLayout());
        add(topBar, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        addListener();

    }

    private void addListener(){
        ToolBarListener listener = new ToolBarListener();

        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bConnection.addActionListener(listener);
        bRecover.addActionListener(listener);
    }

    public CentralPanel getPanel() { return displayPanel; }
}
