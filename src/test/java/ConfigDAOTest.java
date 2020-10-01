import bean.Config;
import dao.ConfigDAO;
import dao.DAORepo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.ApplicationContextHolder;

import java.util.List;

public class ConfigDAOTest {
    private DAORepo configDAO = ApplicationContextHolder.getBean("configDao");

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }


    @Test
    public void addTest() {
        Config config = ApplicationContextHolder.getBean("config");
        config.setKey("TEST_ADD");
        config.setId(100);
        configDAO.add(config);
        Config config1 = configDAO.getByKey("TEST_ADD");
        Assert.assertEquals(config1.getId(), config.getId());
        configDAO.delete(config);
    }

    @Test
    public void updateTest() {
        Config config = ApplicationContextHolder.getBean("config");
        config.setId(101);
        configDAO.add(config);
        config.setValue("TEST_UPDATE");
        configDAO.update(config);
        Config config1 = configDAO.search(101);
        Assert.assertEquals(config1.getValue(), "TEST_UPDATE");
        configDAO.delete(config);
    }

    @Test
    public void deletTest() {
        Config config = ApplicationContextHolder.getBean("config");
        config.setId(102);
        configDAO.delete(config);
        Config config1 = configDAO.search(102);
        Assert.assertNull(config1);
    }

    @Test
    public void listTest() {
        List<Config> configs = configDAO.list();
        Assert.assertEquals(configs.size(), configDAO.getAll());
    }

    // Put int i = 1 / 0 to raise an exception in ConfigDAO.add()
    @Test
    public void transactionTest() {
        Config config = ApplicationContextHolder.getBean("config");
        config.setKey("transaction");
        configDAO.add(config);
        Config config1 = configDAO.getByKey("transaction");
        Assert.assertNull(config1);
    }

}
