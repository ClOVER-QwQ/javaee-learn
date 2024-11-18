package com.clover.dao.impl;

import com.clover.dao.PoemDao;
import com.clover.mapper.PoemMapper;
import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("poemDao")
public class PoemDaoImpl implements PoemDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int insertByPoem(Poem poem) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.insertByPoem(poem);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int batchInsert(List<Poem> poems) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.batchInsert(poems);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int insert(String title, String content, String translation, int authorId, int poemTypeId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.insert(title, content, translation, authorId, poemTypeId);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int batchDeleteByIds(List<Integer> ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            mapper.batchDeleteByIds(ids);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.deleteById(id);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int deleteByTitle(String title) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.deleteByTitle(title);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int selectCollectorCountById(int poemId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.selectCollectorCountById(poemId);
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int updateById(int id, String title, String content, String translation, int authorId, int poemTypeId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.updateById(id, title, content, translation, authorId, poemTypeId);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int updateTitleById(int id, String title) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            int result = mapper.updateTitleById(id, title);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Poet selectPoetByPoemId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            Poet result = mapper.selectPoetByPoemId(id);
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Poem> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            List<Poem> result = (List<Poem>) mapper.selectAll();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Poem> selectByMulti(String content) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            List<Poem> result = mapper.selectByMulti(content);
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<String> selectUserByPoemId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            List<String> result = mapper.selectUserByPoemId(id);
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Map selectByIdWithPoet(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            Map result = mapper.selectByIdWithPoet(id);
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Poem selectByTitle(String title) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            Poem result = mapper.selectByTitle(title);
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Poem selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PoemMapper mapper = sqlSession.getMapper(PoemMapper.class);
            Poem result = mapper.selectById(id);
            return result;
        } finally {
            sqlSession.close();
        }
    }
}