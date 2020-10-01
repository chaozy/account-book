package gui.listener;

import service.ConfigService;
import gui.panel.ConfigPanel;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigSubmitListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel configPanel = ConfigPanel.getInstance();
        if (!GUIUtil.isNumberTextField(configPanel.getBudget(), "Budget of this month")){
            // GUIUtil.isNumberTextField will prompt the error message,
            // so nothing should be done here
            return;
        }
        JTextField sqlPath = configPanel.getPath();
        if (!GUIUtil.isEmptyTextField(sqlPath, "SQL path")){
            return;
        }

        // Finished checking validity of entered information, import data into database through service class
        ConfigService service = new ConfigService();
        service.update(ConfigService.budget, configPanel.getBudget().getText());
        service.update(ConfigService.mysqlPath, configPanel.getPath().getText());
        JOptionPane.showMessageDialog(null,"Successfully updated");
    }
}
