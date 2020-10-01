package dao;

import org.springframework.transaction.annotation.Transactional;
import bean.Record;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
@Transactional
public class RecordDAO extends DAORepo {
    @Override
    protected void doAdd(SqlSession sqlSession, Object object) {
        Record record = (Record)object;
        sqlSession.insert("record.add", record);
    }

    @Override
    protected void doDelete(SqlSession sqlSession, Object object) {
        Record record = (Record)object;
        sqlSession.delete("record.delete", record);
    }

    @Override
    protected void doUpdate(SqlSession sqlSession, Object object) {
        Record record = (Record)object;
        sqlSession.update("record.update", record);
    }

    @Override
    protected int doGetTotal(SqlSession sqlSession) {
        return sqlSession.selectList("category.selectAll").size();
    }

    @Override
    protected <T> T doSearch(SqlSession sqlSession, int id) {
        return sqlSession.selectOne("record.selectByID", id);
    }

    @Override
    protected <T> List<T> doList(SqlSession sqlSession, int startID, int endID) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startID", startID);
        map.put("endID", endID);
        List<Record> records = sqlSession.selectList("record.list", map);
        return (List<T>) records;
    }

    @Override
    protected <T> T doSearchByName(SqlSession sqlSession, String name) {
        return null;
    }

    @Override
    protected void doDeleteByCID(SqlSession sqlSession, int cid) {
        sqlSession.delete("record.deleteByCID", cid);
    }

    @Override
    protected <T> List<T> doListByDate(SqlSession sqlSession, Date startDate, Date endDate) {
        HashMap<String, java.util.Date> map = new HashMap<>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);

        return sqlSession.selectList("record.listDateRange", map);
    }

    @Override
    protected <T> List<T> doListByCID(SqlSession sqlSession, int cid) {
        return sqlSession.selectList("selectByCID", cid);
    }

    @Override
    protected <T> T getByKey(SqlSession sqlSession, String key) {
        return null;
    }


}
