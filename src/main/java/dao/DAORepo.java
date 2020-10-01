package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.DateUtil;

import java.util.Date;
import java.util.List;

@Repository
public abstract class DAORepo {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

// The method below are basic CRUD operations
    public void add(Object o) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        doAdd(sqlSession, o);
        sqlSession.close();
    }

    public void delete(Object o) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        doDelete(sqlSession, o);
        sqlSession.close();
    }

    public void update(Object o) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        doUpdate(sqlSession, o);
        sqlSession.close();
    }

    public int getAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int total = doGetTotal(sqlSession);
        sqlSession.close();
        return total;
    }

    public <T> T search(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        T object = doSearch(sqlSession, id);
        sqlSession.close();
        return object;
    }

    public <T> List<T> list() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<T> objects = doList(sqlSession, 0, Short.MAX_VALUE);
        sqlSession.close();
        return objects;
    }

    public <T> List<T> list(int startID, int endID) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<T> objects = doList(sqlSession, startID, endID);
        sqlSession.close();
        return objects;
    }
/****************************************************************/
// Below method belongs to CategoryDAO
    public <T> T searchByName(String name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        T object = doSearchByName(sqlSession, name);
        sqlSession.close();
        return object;
    }

/****************************************************************/
// Below methods belong to RecordDAO
    public void deleteByCID(int cid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        doDeleteByCID(sqlSession, cid);
        sqlSession.close();
    }

    public <T> List<T> listByDate(Date date) {
        return listByDate(date, date);
    }

    public <T> List<T> listByDate(Date startDate, Date endDate) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<T> objects = doListByDate(sqlSession, startDate, endDate);
        sqlSession.close();
        return objects;
    }

    public <T> List<T> listByCID(int cid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<T> objects = doListByCID(sqlSession, cid);
        sqlSession.close();
        return objects;
    }

    public <T> List<T> listThisMoth() {
        return listByDate(DateUtil.monthBegin(), DateUtil.monthEnd());
    }

    /****************************************************************/
    // Below method belongs to ConfigDAO
    public <T> T getByKey(String key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        T object = getByKey(sqlSession, key);
        sqlSession.close();
        return object;
    }

    protected abstract void doAdd(SqlSession sqlSession, Object object);
    protected abstract void doDelete(SqlSession sqlSession, Object object);
    protected abstract void doUpdate(SqlSession sqlSession, Object object);
    protected abstract int doGetTotal(SqlSession sqlSession);
    protected abstract <T> T doSearch(SqlSession sqlSession, int id);
    protected abstract <T> List<T> doList(SqlSession sqlSession, int startID, int endID);

    protected abstract <T> T doSearchByName(SqlSession sqlSession, String name);

    protected abstract void doDeleteByCID(SqlSession sqlSession, int cid);
    protected abstract <T> List<T> doListByDate(SqlSession sqlSession, Date startDate, Date endDate);
    protected abstract <T> List<T> doListByCID(SqlSession sqlSession, int cid);

    protected abstract <T> T getByKey(SqlSession sqlSession, String key);
}
