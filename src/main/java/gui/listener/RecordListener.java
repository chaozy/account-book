package gui.listener;

import dao.CategoryDAO;
import dao.DAORepo;
import org.springframework.context.ApplicationContext;
import service.CategoryService;
import gui.panel.CategoryPanel;
import gui.panel.ExpensePanel;
import gui.MainPanel;
import gui.panel.RecordPanel;
import service.RecordService;
import gui.util.GUIUtil;
import util.ApplicationContextHolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel panel = RecordPanel.getInstance();
        if (new CategoryService().list().size() == 0){
            JOptionPane.showMessageDialog(panel, "NO category is recorded, set category first");
            MainPanel.getInstance().getPanel().display(CategoryPanel.getInstance());
            return;
        }
        if (!GUIUtil.isNumberTextField(panel.getExpense(), "Expense")){
            return;
        }
        int spend = Integer.parseInt(panel.getExpense().getText());
        String category = panel.getSelectedItem(0);
        String payment = panel.getSelectedItem(1);
        String description = panel.getDescription().getText();
        Date date = panel.getDate().getDate();
        new RecordService().add(spend, category, payment, description, date);

        JOptionPane.showMessageDialog(panel, "Successfully recorded");
        MainPanel.getInstance().getPanel().display(ExpensePanel.getInstance());

    }
}
