package gui.model;

import bean.Category;
import dao.CategoryDAO;
import service.CategoryService;
import util.ApplicationContextHolder;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class CategoryTableModel implements TableModel {
    private String[] columnNames = new String[] {"CATEGORIES", "TIMES"};
    private List<Category> categoryList = new CategoryService().list();

    public List<Category> getList(){
        return categoryList;
    }

    public void setList(List<Category> newList){
        categoryList = newList;
    }

    @Override
    public int getRowCount() {
        return categoryList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return categoryList.get(rowIndex).getName();
        }
        else if (columnIndex == 1){
            return categoryList.get(rowIndex).getRecordNumber();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
