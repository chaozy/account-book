package startup;

import dao.CategoryDAO;
import dao.DAORepo;
import gui.MainFrame;
import gui.panel.ExpensePanel;
import gui.MainPanel;
import gui.util.GUIUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.setSkin();
        SwingUtilities.invokeAndWait(() -> {
            // initialise the context, so ApplicationContextAware will be executed
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


            MainFrame.getInstance().setVisible(true);
            MainPanel.getInstance().getPanel().display(ExpensePanel.getInstance());
        });
    }
}
