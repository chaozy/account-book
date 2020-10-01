package dao;

import bean.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CategoryDAO extends DAORepo{

    @Override
    protected void doAdd(SqlSession sqlSession, Object object) {
        Category category = (Category)object;
        sqlSession.insert("category.add", category);
    }

    @Override
    protected void doDelete(SqlSession sqlSession, Object object) {
        Category category = (Category)object;
        sqlSession.delete("category.delete", category);
    }

    @Override
    protected void doUpdate(SqlSession sqlSession, Object object) {
        Category category = (Category)object;
        sqlSession.update("category.update", category);
    }

    @Override
    protected int doGetTotal(SqlSession sqlSession) {
        List<Category> categories = sqlSession.selectList("category.selectAll");
        return categories.size();
    }

    @Override
    protected  <T> T doSearch(SqlSession sqlSession, int id) {
        return sqlSession.selectOne("category.selectByID", id);
    }

    @Override
    protected  <T> List<T> doList(SqlSession sqlSession, int startID, int endID) {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", startID);
        map.put("end", endID);
        List<Category> categories = sqlSession.selectList("category.pagination", map);
        return (List<T>) categories;
    }

    @Override
    protected <T> T doSearchByName(SqlSession sqlSession, String name) {
        return sqlSession.selectOne("category.selectByName", name);
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
        return null;
    }

}

