package gui.util;

/**
 * GUIUtil contains tool methods either used for testing or later work.
 */


import javax.swing.*;
import java.awt.*;

public class GUIUtil {
    public static boolean isEmptyTextField(JTextField tf, String input){
        if (tf.getText() == null || tf.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, input + " Can't be empty");
            // pop up the error message
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean isNumberTextField(JTextField tf, String input){
        if (!isEmptyTextField(tf, input)){ return false; }
        String in = tf.getText().trim();
        try{
            int number = Integer.parseInt(in);
            return true;
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, input + " Input should be integer");
            tf.grabFocus();
            return false;
        }
    }

    public static boolean isZeroTextField(JTextField tf, String input){
        if (!isNumberTextField(tf, input)){ return false; }
        if (Integer.parseInt(tf.getText().trim()) == 0) {
            JOptionPane.showMessageDialog(null, input + " Input can not be ZERO");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * Set specified colour to all given JComponents
     * @param colour
     * @param components
     */
    public static void setColour(Color colour, JComponent... components){
        for (JComponent component : components){
            component.setBackground(colour);
        }
    }

    /**
     * Set sepcified font to provided JComponents
     */
    public static void setFont(Font font, JComponent... components){
        for (JComponent component : components){
            component.setFont(font);
        }
    }

    /**
     * Set the specified icon to the given JButton
     * @param button
     * @param fileName
     * @param tip
     */
    public static void setImageIcon(JButton button, String fileName, String tip){
        ImageIcon icon = new ImageIcon(fileName);
        button.setIcon(icon);
        button.setToolTipText(tip);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setText(tip);
    }

    /**
     * Set the skin of the panel to liquid
     */
    public static void setSkin() {
        // only the liquid skin is used here
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Display a panel, used for testing panel
     * @param panel
     * @param streching
     */
    public static void showPanel(JPanel panel, double streching){
        setSkin();
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        CentralPanel cp = new CentralPanel(streching);
        frame.setContentPane(cp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        cp.display(panel);
    }

    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }

}
