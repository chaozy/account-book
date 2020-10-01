package gui.panel;

import bean.Category;
import dao.CategoryDAO;
import gui.listener.CategoryListener;
import org.springframework.beans.factory.annotation.Autowired;
import service.CategoryService;
import gui.model.CategoryTableModel;
import gui.util.GUIUtil;
import util.ApplicationContextHolder;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends WorkingPanel {
    static{
        GUIUtil.setSkin();
    }

    private static CategoryPanel panel = new CategoryPanel();

    public static CategoryPanel getInstance() { return panel; }

    private  CategoryTableModel model = new CategoryTableModel();
    private JTable table = new JTable(model);
    private JButton bAdd = new JButton("ADD");
    private JButton bDelete = new JButton("DELETE");
    private JButton bEdit = new JButton("EDIT");
    private JButton bClear = new JButton("CLEAR");

    public JButton getAddButton() { return bAdd; }
    public JButton getDeleteButton() { return bDelete; }
    public JButton getEditButton() { return bEdit; }
    public JButton getClearButton() { return bClear; }

    public CategoryPanel(){

        this.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        buttonPanel.add(bAdd, c);
        c.gridx = 1;
        buttonPanel.add(bEdit, c);
        c.gridx = 2;
        buttonPanel.add(bDelete, c);
        c.gridx = 3;
        buttonPanel.add(bClear, c);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.addListener();
    }

    public Category getSelectedCategory(){
        int index = table.getSelectedRow();
        return model.getList().get(index);
    }
    @Override
    public void addListener(){
        CategoryListener categoryListener = new CategoryListener();
        bAdd.addActionListener(categoryListener);
        bEdit.addActionListener(categoryListener);
        bDelete.addActionListener(categoryListener);
        bClear.addActionListener(categoryListener);
    }

    @Override
    public void updatePanel() {
        model.setList(new CategoryService().list());
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0, 0);

        if (model.getList().size() == 0){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }
        else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }
}
