package service;

import bean.Category;
import bean.Record;
import dao.CategoryDAO;
import dao.DAORepo;
import dao.RecordDAO;
import util.ApplicationContextHolder;

import java.util.Date;

public class RecordService {
    private DAORepo dao = ApplicationContextHolder.getBean("recordDao");
    private DAORepo categoryDAO = ApplicationContextHolder.getBean("categoryDao");

    public void add(int spend, String category, String payment, String comment, Date date){
        Record record = new Record();
        record.setSpend(spend);
        Category category1 = categoryDAO.searchByName(category);
        record.setCid(category1.getId());
        record.setPayment(payment);
        record.setDate(date);
        record.setComment(comment);
        dao.add(record);
    }
}
