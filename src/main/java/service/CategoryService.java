package service;

import bean.Category;
import bean.Record;
import dao.CategoryDAO;
import dao.DAORepo;
import dao.RecordDAO;
import org.springframework.stereotype.Service;
import util.ApplicationContextHolder;

import java.util.List;

@Service
public class CategoryService {
    private DAORepo categoryDAO = ApplicationContextHolder.getBean("categoryDao");

    private DAORepo recordDAO = ApplicationContextHolder.getBean("recordDao");


    public List<Category> list(){
        List<Category> categories = categoryDAO.list();
        for (Category category : categories){
            List<Record> rs = recordDAO.listByCID(category.getId());
            category.setRecordNumber(rs.size());
        }
        return categories;
    }

    public void add(String name){
        Category newCategory = new Category();
        newCategory.setName(name);
        categoryDAO.add(newCategory);
    }

    public void update(int id, String name){
        Category category = new Category();
        category.setName(name);
        category.setId(id);
        categoryDAO.update(category);
    }

    public void delete(int id){
        categoryDAO.delete(id);
    }

    public void deleteAll(Category category){
        recordDAO.delete(category.getId());
    }

}
