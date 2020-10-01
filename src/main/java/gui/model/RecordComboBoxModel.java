package gui.model;

/**
 * This class works as the data model for the combobox in recordPanel
 */

import bean.Category;
import dao.CategoryDAO;
import service.CategoryService;
import util.ApplicationContextHolder;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class RecordComboBoxModel implements ComboBoxModel<String> {
    private List<String> comboBoxes = new ArrayList<>();
    private String displaying;


    public RecordComboBoxModel(){
        for (Category category : new CategoryService().list()){
            comboBoxes.add(category.getName());
        }
        if (comboBoxes.size() != 0) {
            displaying = comboBoxes.get(0);
        }
    }


    public RecordComboBoxModel(List<String> list){
        comboBoxes = list;
        displaying = comboBoxes.get(0);
    }

    public void resetComboBoxes(){
        comboBoxes.clear();
        for (Category category : new CategoryService().list()){
            comboBoxes.add(category.getName());
        }
        if (comboBoxes.size() != 0){
            displaying = comboBoxes.get(0);
        }
        else {
            displaying = "";
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        displaying = (String)anItem;
    }

    @Override
    public Object getSelectedItem(){
        return displaying;
    }

    @Override
    public int getSize() {
        return comboBoxes.size();
    }

    @Override
    public String getElementAt(int index) {
        return comboBoxes.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
