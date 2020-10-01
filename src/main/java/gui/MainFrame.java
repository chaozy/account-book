package gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = new MainFrame();

    public static MainFrame getInstance() { return instance; }

    public MainFrame(){
        this.setSize(500,600);
        this.setTitle("Account Book");
        this.setContentPane(MainPanel.getInstance());
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
