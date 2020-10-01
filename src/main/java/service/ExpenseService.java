package service;

import dao.DAORepo;
import lombok.Getter;
import util.DateUtil;
import bean.Record;
import util.ApplicationContextHolder;

import java.util.Date;
import java.util.List;

@Getter
public class ExpenseService {
    private int usagepecentage;
    private int totalSpend;
    private int monthSpend;
    private int todaySpend;
    private double avgSpendPerDay;
    private int monthAvailable;
    private double dayAvgAvailable;
    private int timeLeft;
    private int monthBudget;

    public boolean overBudget(){
        return monthBudget < monthSpend;
    }

    public ExpenseService(){
        DAORepo recordDAO = ApplicationContextHolder.getBean("recordDao");

        List<Record> totalRecordList = recordDAO.list();
        for(Record record : totalRecordList){
            totalSpend += record.getSpend();
        }

        List<Record> recordList = recordDAO.listThisMoth();
        for (Record record : recordList){
            monthSpend += record.getSpend();
        }

        List<Record> recordTodayList = recordDAO.listByDate(new Date());
        for (Record record  : recordTodayList){
            todaySpend += record.getSpend();
        }

        avgSpendPerDay = monthSpend / DateUtil.daysPassInMonth();

        monthBudget = new ConfigService().getBudget();
        monthAvailable = monthBudget - monthSpend;

        dayAvgAvailable = monthBudget / DateUtil.daysInMonth() - todaySpend;

        timeLeft = DateUtil.daysLeftInMonth();

        usagepecentage = monthSpend * 100 / monthBudget;
    }
}
