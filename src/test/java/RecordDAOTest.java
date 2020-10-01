import bean.Record;
import dao.DAORepo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.ApplicationContextHolder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecordDAOTest {
    private DAORepo recordDAO = ApplicationContextHolder.getBean("recordDao");

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void addTest() {
        Record record = ApplicationContextHolder.getBean("record");
        record.setSpend(520);
        record.setCid(1);
        recordDAO.add(record);
        List<Record> records = recordDAO.listByCID(1);
        Assert.assertTrue(!records.isEmpty());
    }

    @Test
    public void deleteTest() {
        recordDAO.delete(1);
        List<Record> records = recordDAO.listByCID(1);
        Assert.assertTrue(records.isEmpty());
    }

    @Test
    public void listByIDTest() {
        List<Record> records = recordDAO.list(1, 10);
        boolean result = true;
        for (Record record : records) {
            result = (record.getId() > 1 && record.getId() < 10);
        }
        Assert.assertTrue(result);
    }

    public void listByDateTest() {
        Date end = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(end);
        c.add(Calendar.MONTH, 1);
        Date start = c.getTime();
        List<Record> records = recordDAO.listThisMoth();

        boolean result = true;
        for (Record record : records) {
            result = (record.getDate().after(start) && record.getDate().before(end));
        }
        Assert.assertTrue(result);
    }
}
