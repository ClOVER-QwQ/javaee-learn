package com.clover.dao;

import com.clover.pojo.Poem;
import com.clover.pojo.Poet;

import java.util.List;
import java.util.Map;

public interface PoemDao {

    // 批量插入诗歌
    int insertByPoem(Poem poem);

    // 批量插入诗歌
    int batchInsert(List<Poem> poems);

    // 插入单首诗歌
    int insert(String title, String content, String translation, int authorId, int poemTypeId);

    // 根据id删除诗歌记录
    int batchDeleteByIds(List<Integer> ids);

    // 根据id删除诗歌记录
    int deleteById(int id);

    // 根据标题删除诗歌记录
    int deleteByTitle(String title);

    // 通过诗文ID查询有多少人收藏
    int selectCollectorCountById(int poemId);

    // 更新诗歌记录
    int updateById(int id, String title, String content, String translation, int authorId, int poemTypeId);

    // 更新诗歌标题
    int updateTitleById(int id, String title);

    // 根据id查询诗歌记录
    Poet selectPoetByPoemId(int id);

    // 查询所有诗歌
    List<Poem> selectAll();

    // 根据内容查询诗歌
    List<Poem> selectByMulti(String content);

    // 根据诗歌 id 查询收藏该诗歌的用户列表
    List<String> selectUserByPoemId(int id);

    // 根据 id 查询诗歌详情
    Map<String, Object> selectByIdWithPoet(int id);

    // 根据标题查询诗歌详情
    Poem selectByTitle(String title);

    //根据id查询
    Poem selectById(int id);
}