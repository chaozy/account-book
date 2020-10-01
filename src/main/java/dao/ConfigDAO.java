package dao;

import bean.Config;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class performs object-relational mapping between config objects and Config table
 */
@Repository
@Transactional
public class ConfigDAO extends DAORepo{
    @Override
    protected void doAdd(SqlSession sqlSession, Object object) {
        Config config = (Config) object;
        sqlSession.insert("config.add", config);
    }

    @Override
    protected void doDelete(SqlSession sqlSession, Object object) {
        Config config = (Config) object;
        sqlSession.delete("config.delete", config);
    }

    @Override
    protected void doUpdate(SqlSession sqlSession, Object object) {
        Config config = (Config) object;
        sqlSession.update("config.update", config);
    }

    @Override
    protected int doGetTotal(SqlSession sqlSession) {
        return sqlSession.selectList("config.selectAll").size();
    }

    @Override
    protected <T> T doSearch(SqlSession sqlSession, int id) {
        return sqlSession.selectOne("config.selectByID", id);
    }

    @Override
    protected <T> List<T> doList(SqlSession sqlSession, int startID, int endID) {
        Map<String, Integer> map = new HashMap<>();
        map.put("startID", startID);
        map.put("endID", endID);
        List<Config> configs = sqlSession.selectList("config.selectByIDRange", map);
        return (List<T>) configs;
    }

    @Override
    protected <T> T doSearchByName(SqlSession sqlSession, String name) {
        return null;
    }

    @Override
    protected void doDeleteByCID(SqlSession sqlSession, int cid) {

    }

    @Override
    protected <T> List<T> doListByDate(SqlSession sqlSession, Date startDate, Date endDate) {
        return null;
    }

    @Override
    protected <T> List<T> doListByCID(SqlSession sqlSession, int cid) {
        return null;
    }

    @Override
    protected <T> T getByKey(SqlSession sqlSession, String key) {
        return sqlSession.selectOne("config.selectByKey", key);
    }
}
