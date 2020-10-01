package gui.panel;

import gui.listener.ConfigBrowseListener;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConnectionPanel extends WorkingPanel {

    private static ConnectionPanel instance = new ConnectionPanel();
    public static ConnectionPanel getInstance() { return instance; }

    private JLabel lIP = new JLabel("IP");
    private JTextField tfIP = new JTextField();

    private JLabel lPort = new JLabel("Port");
    private JTextField tfPort = new JTextField();

    private JLabel lSchema = new JLabel("Schema");
    private JTextField tfSchema = new JTextField();

    private JLabel lEncoding = new JLabel("Encoding");
    private JTextField tfEncoding = new JTextField();

    private JLabel lLoginName = new JLabel("Login Name");
    private JTextField tfLogin = new JTextField();

    private JLabel lPasswd = new JLabel("Password");
    private JPasswordField tfPasswd = new JPasswordField();

    public JTextField getTfIP() { return tfIP; }

    public JTextField getTfPort() { return tfPort; }

    public JTextField getTfSchema() { return tfSchema; }

    public JTextField getTfEncoding() { return tfEncoding; }

    public JTextField getTfLogin() { return tfLogin; }

    public JTextField getTfPasswd() { return tfPasswd; }

    private JButton bSubmit = new JButton("SUBMIT");

    public ConnectionPanel() {
        this.setLayout(new GridBagLayout());
        addListener();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(lIP, gbc);
        gbc.gridy = 1;
        this.add(lPort, gbc);
        gbc.gridy = 2;
        this.add(lSchema, gbc);
        gbc.gridy = 3;
        this.add(lEncoding, gbc);
        gbc.gridy = 4;
        this.add(lLoginName, gbc);
        gbc.gridy = 5;
        this.add(lPasswd, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 300;
        this.add(tfIP, gbc);
        gbc.gridy = 1;
        this.add(tfPort, gbc);
        gbc.gridy = 2;
        this.add(tfSchema, gbc);
        gbc.gridy = 3;
        this.add(tfEncoding, gbc);
        gbc.gridy = 4;
        this.add(tfLogin, gbc);
        tfPasswd.setEchoChar('*');
        gbc.gridy = 5;
        this.add(tfPasswd, gbc);

    }
    @Override
    public void addListener() {

    }

    @Override
    public void updatePanel() {

    }
//
//    public static void main(String[] args) {
//        GUIUtil.showPanel(ConnectionPanel.getInstance());
//    }
}
