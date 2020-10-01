package gui.util;

import gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Centering the JComponent
 */
public class CentralPanel extends JPanel {
    private double rate;       // rate is the (component size / container size)
    private JComponent component;
    private boolean streaching;

    public CentralPanel(double rate, boolean streaching){
        this.setLayout(null);  //null layout means absolute positioning - you have to do all the work in your code.
        this.rate = rate;
        this.streaching = streaching;
    }

    public CentralPanel(double rate){
        // streaching is set to true as default
        this(rate, true);
    }

    public void repaint(){

        if (component != null){
            Dimension containerSize = this.getSize();
            Dimension componentSize = component.getPreferredSize();

            if (streaching){
                component.setSize((int)(containerSize.width * rate), (int)(containerSize.height * rate));
            }
            else{ component.setSize(componentSize); }

            component.setLocation((int)(containerSize.width / 2 - component.getSize().getWidth() / 2),
                    (int)(containerSize.height / 2 - component.getSize().getHeight() / 2));
        }
        super.repaint();
    }

    public void display(JComponent component){
        this.component = component;
        Component[] components = getComponents();
        for(Component c : components){
            this.remove(c);
        }
        this.add(component);

        if (component instanceof WorkingPanel){
            ((WorkingPanel) component).updatePanel();
        }
        this.updateUI();
    }

    public static void main(String[] args) {
        JButton testButton = new JButton("CENTRAL BUTTON");

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        CentralPanel c = new CentralPanel(0.5);
        frame.setLocationRelativeTo(null);
        //frame.add(c);  // has the same functionality here as setContentPane()
        frame.setContentPane(c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        c.display(testButton);
    }
}
