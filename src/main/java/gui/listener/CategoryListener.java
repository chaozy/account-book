package gui.listener;

import bean.Category;
import gui.panel.CategoryPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class CategoryListener implements ActionListener {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel categoryPanel = CategoryPanel.getInstance();
        JButton button = (JButton)e.getSource();
        if (button == categoryPanel.getAddButton()) {
            String name = JOptionPane.showInputDialog("NAME of NEW CATEGORY");
            if (name.length() == 0){
                JOptionPane.showMessageDialog(null, "Name of Category cannot be epsilon");
                return ;
            }
            else{
                categoryService.add(name);
            }
        }

        else if (button == categoryPanel.getDeleteButton()){
            Category selectedCategory = categoryPanel.getSelectedCategory();
            if (selectedCategory.getRecordNumber() != 0){
                JOptionPane.showMessageDialog(categoryPanel,
                        "Expense record under this category, deletion is not permitted");
            }
            else {
                categoryService.delete(selectedCategory.getId());
            }
        }

        else if (button == categoryPanel.getEditButton()){
            Category selectedCategory = categoryPanel.getSelectedCategory();
            String name = JOptionPane.showInputDialog("NAME of NEW CATEGORY");
            if (name.length() == 0){
                JOptionPane.showMessageDialog(null, "Name of Category cannot be epsilon");
                return ;
            }
            categoryService.update(selectedCategory.getId(), name);
        }

        else if (button == categoryPanel.getClearButton()){
            Category selectedCategory = categoryPanel.getSelectedCategory();
            int answer = JOptionPane.showConfirmDialog(null,
                    "clear all record under this category?");
            if (answer == JOptionPane.YES_OPTION){
                categoryService.deleteAll(selectedCategory);
            }
        }
        categoryPanel.updatePanel();
    }
}
