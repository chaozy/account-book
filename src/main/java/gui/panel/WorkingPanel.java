package gui.panel;

import javax.swing.*;

/**
 * WorkingPanel defines two abstract methods, one is adding listeners to JComponent
 * The other is updating data shown on the panel
 */
public abstract class WorkingPanel extends JPanel {
    public abstract void addListener();
    public abstract void updatePanel();
}
