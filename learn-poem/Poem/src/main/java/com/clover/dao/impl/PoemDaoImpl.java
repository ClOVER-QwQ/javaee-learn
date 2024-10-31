package com.clover.dao.impl;

import com.clover.dao.PoemDao;
import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public class PoemDaoImpl implements PoemDao {
    @Override
    public int insertByPoem(Poem poem) {
        return 0;
    }

    @Override
    public int batchInsert(List<Poem> poems) {
        return 0;
    }

    @Override
    public int insert(String title, String content, String translation, int authorId, int poemTypeId) {
        return 0;
    }

    @Override
    public void batchDeleteByIds(List<Integer> ids) {

    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int deleteByTitle(String title) {
        return 0;
    }

    @Override
    public int selectCollectorCountById(int poemId) {
        return 0;
    }

    @Override
    public int updateById(int id, String title, String content, String translation, int authorId, int poemTypeId) {
        return 0;
    }

    @Override
    public int updateTitleById(int id, String title) {
        return 0;
    }

    @Override
    public Poet selectPoetByPoemId(int id) {
        return null;
    }

    @Override
    public List<Poem> findAll() {
        return null;
    }

    @Override
    public List<Poem> selectByMulti(String content) {
        return null;
    }

    @Override
    public List<String> selectUserByPoemId(int id) {
        return null;
    }

    @Override
    public Map selectByIdWithPoet(int id) {
        return null;
    }

    @Override
    public Poem selectByTitle(String title) {
        return null;
    }

    @Override
    public Poem selectById(int id) {
        return null;
    }
}
