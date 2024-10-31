package com.clover.service.impl;

import com.clover.dao.impl.PoemDaoImpl;
import com.clover.service.PoemService;
import com.clover.dao.PoemDao;
import com.clover.pojo.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("poemService")
public class PoemServiceImpl implements PoemService {
    @Autowired
    private PoemDao poemDao;

    public PoemServiceImpl(PoemDao poemDao) {
        this.poemDao = poemDao;
    }

    @Override
    public void insertByPoem(Poem poem) {
        if (poemDao.selectByTitle(poem.getTitle()) != null){
            System.out.println("该诗歌已存在");
        }
        else {
            poemDao.insertByPoem(poem);
        }
    }

    @Override
    public void deleteByTitle(String title) {
        if (poemDao.selectByTitle(title) != null){
            poemDao.deleteByTitle(title);
        }
        else {
            System.out.println("该诗歌不存在");
        }
    }

    @Override
    public void updateTitleById(int id, String title) {
        if (poemDao.selectById(id) != null){
            poemDao.updateTitleById(id, title);
        }
        else {
            System.out.println("该诗歌不存在");
        }
    }

    public void setPoemDao(PoemDao poemDao) {

        this.poemDao = poemDao;
    }
}
