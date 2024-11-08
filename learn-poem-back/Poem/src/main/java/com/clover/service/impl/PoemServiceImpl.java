package com.clover.service.impl;

import com.clover.pojo.Poet;
import com.clover.service.PoemService;
import com.clover.dao.PoemDao;
import com.clover.pojo.Poem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("poemService")
public class PoemServiceImpl implements PoemService {
    @Autowired
    private PoemDao poemDao;
    private Logger logger = LoggerFactory.getLogger(PoemService.class);
    @Override
    public List<Poem> selectAll(int pageNum,int pageSize) {
        // 设置分页参数：第1页，每页5条记录
        PageHelper.startPage(pageNum,pageSize);
        // 执行查询
        List<Poem> poems = poemDao.selectAll();
        // 使用PageInfo包装查询结果
        PageInfo<Poem> pageInfo = new PageInfo<>(poems);
        // 打印分页信息
        logger.info("总条数：{}, 总页数：{}, 当前页：{}, 每页数量：{}",
                pageInfo.getTotal(), pageInfo.getPages(),
                pageInfo.getPageNum(), pageInfo.getSize());
        // 打印诗人信息
        poems.forEach(poem -> logger.info("古诗信息：{}", poem));
        return poems;
    }

    @Override
    public List<Poem> selectByMulti(String content, int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Poem> poems = poemDao.selectByMulti(content);
        PageInfo<Poem> pageInfo = new PageInfo<>(poems);
        // 打印分页信息
        logger.info("总条数：{}, 总页数：{}, 当前页：{}, 每页数量：{}",
                pageInfo.getTotal(), pageInfo.getPages(),
                pageInfo.getPageNum(), pageInfo.getSize());
        // 打印诗人信息
        poems.forEach(poem -> logger.info("古诗信息：{}", poem));
        return poems;
    }

    @Override
    public List<String> selectUserByPoemId(int id,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<String> users = poemDao.selectUserByPoemId(id);
        PageInfo<String> pageInfo = new PageInfo<>(users);
        // 打印分页信息
        logger.info("总条数：{}, 总页数：{}, 当前页：{}, 每页数量：{}",
                pageInfo.getTotal(), pageInfo.getPages(),
                pageInfo.getPageNum(), pageInfo.getSize());
        // 打印诗人信息
        users.forEach(user -> logger.info("用户信息：{}", user));
        return users;
    }

    @Override
    public Map<String, Object> selectByIdWithPoet(int id) {
        Map<String, Object> poem = poemDao.selectByIdWithPoet(id);
        return poem;
    }

    @Override
    public Poem selectByTitle(String title) {
        Poem poem = poemDao.selectByTitle(title);
        return poem;
    }

    @Override
    public Poem selectById(int id) {
        Poem poem = poemDao.selectById(id);
        return poem;
    }

    @Override
    public int insertByPoem(Poem poem) {
        int flag;
        if (poemDao.selectByTitle(poem.getTitle()) != null){
            System.out.println("该诗歌已存在");
            flag = 0;
        }
        else {
            poemDao.insertByPoem(poem);
            flag = 1;
        }
        return flag;
    }

    @Override
    public int batchInsert(List<Poem> poems) {
        int count = 0;
        for (Poem poem : poems) {
            if (poemDao.selectById(poem.getId()) == null){
                poemDao.insertByPoem(poem);
                count++;
            }
            else {
                System.out.println("诗歌:"+poem.getTitle()+"已经存在");
            }
        }
        return count;
    }

    @Override
    public int batchDeleteByIds(List<Integer> ids) {
        int count = 0;
        for (int id : ids){
            if (poemDao.selectById(id) != null){
                poemDao.deleteById(id);
                count++;
            }
            else {
                System.out.println("id:"+id+"不存在");
            }
        }
        return count;
    }

    @Override
    public int deleteById(int id) {
        int flag;
        if (poemDao.selectById(id) != null){
            poemDao.deleteById(id);
            flag = 1;
        }
        else {
            System.out.println("该诗歌不存在");
            flag = 0;
        }
        return flag;
    }

    @Override
    public int deleteByTitle(String title) {
        int flag;
        if (poemDao.selectByTitle(title) != null){
            poemDao.deleteByTitle(title);
            flag = 1;
        }
        else {
            System.out.println("该诗歌不存在");
            flag = 0;
        }
        return flag;
    }

    @Override
    public int updateById(int id, String title, String content, String translation, int authorId, int poemTypeId) {
        int flag;
        if (poemDao.selectById(id) != null){
            poemDao.updateById(id,title,content,translation,authorId,poemTypeId);
            flag = 1;
        }
        else {
            System.out.println("该诗歌不存在");
            flag = 0;
        }
        return flag;
    }

    @Override
    public int updateTitleById(int id, String title) {
        int flag;
        if (poemDao.selectById(id) != null){
            poemDao.updateTitleById(id, title);
            flag = 1;
        }
        else {
            System.out.println("该诗歌不存在");
            flag = 0;
        }
        return flag;
    }

    @Override
    public Poet selectPoetByPoemId(int id) {
        Poet poet = poemDao.selectPoetByPoemId(id);
        if (poet == null){
            System.out.println("不存在相关诗人");
        }
        return poet;
    }

    @Override
    public int selectCollectorCountById(int poemId) {
        return poemDao.selectCollectorCountById(poemId);
    }
}
