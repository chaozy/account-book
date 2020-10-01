package gui.listener;

import gui.MainFrame;
import gui.panel.ConfigPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigBrowseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = file.showOpenDialog(MainFrame.getInstance());
        if (result == JFileChooser.APPROVE_OPTION){
            File selected = file.getSelectedFile();
            String s = selected.getAbsolutePath();
            ConfigPanel configPanel = ConfigPanel.getInstance();
            configPanel.setPath(s);
        }
    }
}
