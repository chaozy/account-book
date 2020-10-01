package service;

import dao.DAORepo;
import util.DateUtil;
import bean.Record;
import util.ApplicationContextHolder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * AnalysisService helps to prepare the data for AnalysisPanel
 */
public class AnalysisService {
    private DAORepo recordDAO = ApplicationContextHolder.getBean("recordDao");

    public double[] listSpendThisMonth(){
        Calendar date = Calendar.getInstance();
        Date monthBegin = DateUtil.monthBegin();
        date.setTime(monthBegin);
        int daysInMonth = DateUtil.daysInMonth();
        double[] spendList = new double[daysInMonth];

        for (int i = 0; i < daysInMonth; i++) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            Date dateOfEachDay = date.getTime();
            int dailyExpend = 0;
            List<Record> todayList = recordDAO.listByDate(dateOfEachDay);

            for (Record record : todayList){
                dailyExpend += record.getSpend();
            }
            spendList[i] = dailyExpend;
        }
        return spendList;
    }
}
