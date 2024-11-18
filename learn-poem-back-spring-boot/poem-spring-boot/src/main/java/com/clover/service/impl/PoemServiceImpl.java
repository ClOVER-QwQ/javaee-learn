package com.clover.service.impl;

import com.clover.mapper.PoemMapper;
import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import com.clover.service.DataSourceService;
import com.clover.service.PoemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Transactional
@Service("poemService2")
public class PoemServiceImpl implements PoemService {
    
    @Autowired
    private PoemMapper poemMapper;
    private Logger logger = LoggerFactory.getLogger(PoemService.class);
    @Override
    public List<Poem> selectAll(int pageNum,int pageSize) {
        // 设置分页参数：第1页，每页5条记录
        PageHelper.startPage(pageNum,pageSize);
        // 执行查询
        List<Poem> poems =  poemMapper.selectAll();
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
        List<Poem> poems = poemMapper.selectByMulti(content);
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
        List<String> users = poemMapper.selectUserByPoemId(id);
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
        Map<String, Object> poem = poemMapper.selectByIdWithPoet(id);
        return poem;
    }

    @Override
    public Poem selectByTitle(String title) {
        Poem poem = poemMapper.selectByTitle(title);
        return poem;
    }

    @Override
    public Poem selectById(int id) {
        Poem poem = poemMapper.selectById(id);
        return poem;
    }

    @Override
    public int insertByPoem(Poem poem) {
        int flag;
        if (poemMapper.selectByTitle(poem.getTitle()) != null){
            System.out.println("该诗歌已存在");
            flag = 0;
        }
        else {
            poemMapper.insertByPoem(poem);
            flag = 1;
        }
        return flag;
    }

    @Override
    public int batchInsert(List<Poem> poems) {
        int count = 0;
        for (Poem poem : poems) {
            if (poemMapper.selectById(poem.getId()) == null){
                poemMapper.insertByPoem(poem);
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
            if (poemMapper.selectById(id) != null){
                poemMapper.deleteById(id);
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
        if (poemMapper.selectById(id) != null){
            poemMapper.deleteById(id);
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
        if (poemMapper.selectByTitle(title) != null){
            poemMapper.deleteByTitle(title);
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
        if (poemMapper.selectById(id) != null){
            poemMapper.updateById(id,title,content,translation,authorId,poemTypeId);
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
        if (poemMapper.selectById(id) != null){
            poemMapper.updateTitleById(id, title);
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
        Poet poet = poemMapper.selectPoetByPoemId(id);
        if (poet == null){
            System.out.println("不存在相关诗人");
        }
        return poet;
    }

    @Override
    public int selectCollectorCountById(int poemId) {
        return poemMapper.selectCollectorCountById(poemId);
    }
}
