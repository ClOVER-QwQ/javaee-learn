package com.clover.mapper;

import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface PoemMapper {

    // 批量插入诗歌
    @Insert({"INSERT INTO learnpoem.poems " +
            "(title, content, translation, authorId, poemTypeId) " +
            "VALUES " +
            "(#{title}, #{content}, #{translation}, #{authorId}, #{poemTypeId})"})
    int insertByPoem(Poem poem);

    // 批量插入诗歌
    @Insert("<script>" +
            "INSERT INTO learnpoem.poems " +
            "(title, content, translation, authorId, poemTypeId) " +
            "VALUES " +
            "<foreach collection='list' item='poem' separator=','>" +
            "(#{poem.title}, #{poem.content}, #{poem.translation}, #{poem.authorId}, #{poem.poemTypeId})" +
            "</foreach>" +
            "</script>")
    int batchInsert(List<Poem> poems);

    // 插入单首诗歌
    @Insert("INSERT INTO learnpoem.poems " +
            "(title, content, translation, authorId, poemTypeId) " +
            "VALUES " +
            "(#{title}, #{content}, #{translation}, #{authorId}, #{poemTypeId})")
    int insert(@Param("title") String title, @Param("content") String content,
               @Param("translation") String translation, @Param("authorId") int authorId,
               @Param("poemTypeId") int poemTypeId);

    // 根据id删除诗歌记录
    @Delete("<script>" +
            "DELETE FROM learnpoem.poems " +
            "WHERE id IN " +
            "<foreach collection='list' item='id' open='(' separator=',' close=')'> " +
            "#{id} " +
            "</foreach>" +
            "</script>")
    void batchDeleteByIds(List<Integer> ids);

    // 根据id删除诗歌记录
    @Delete("DELETE FROM learnpoem.poems WHERE id = #{id}")
    int deleteById(@Param("id") int id);

    // 根据标题删除诗歌记录
    @Delete("DELETE FROM learnpoem.poems WHERE title = #{title}")
    int deleteByTitle(@Param("title") String title);

    // 通过诗文ID查询有多少人收藏
    @Select("SELECT COUNT(DISTINCT user_id) FROM collections " +
            "WHERE resource_type = 'poem' AND resource_id = #{poemId}")
    int selectCollectorCountById(@Param("poemId") int poemId);

    // 更新诗歌记录
    @Update("UPDATE learnpoem.poems " +
            "SET title = #{title}, content = #{content}, translation = #{translation}, " +
            "authorId = #{authorId}, poemTypeId = #{poemTypeId} " +
            "WHERE id = #{id}")
    int updateById(@Param("id") int id, @Param("title") String title,
                    @Param("content") String content, @Param("translation") String translation,
                    @Param("authorId") int authorId, @Param("poemTypeId") int poemTypeId);

    // 更新诗歌标题
    @Update("UPDATE learnpoem.poems SET title = #{title} WHERE id = #{id}")
    int updateTitleById(@Param("id") int id, @Param("title") String title);

    // 根据id查询诗歌记录
    @Select("SELECT * FROM poets JOIN poems ON poems.authorId = poets.id WHERE poems.id = #{id}")
    Poet selectPoetByPoemId(@Param("id") int id);

    // 查询所有诗歌
    @Select("SELECT * FROM learnpoem.poems")
    List<Poem> findAll();

    // 根据内容查询诗歌
    @Select("SELECT * FROM learnpoem.poems " +
            "WHERE content LIKE CONCAT('%', #{content}, '%')")
    List<Poem> selectByMulti(@Param("content") String content);

    // 根据诗歌 id 查询收藏该诗歌的用户列表
    @Select("SELECT users.username FROM collections " +
            "JOIN users ON collections.user_id = users.id " +
            "WHERE collections.resource_id = #{id} AND resource_type = 'poem'")
    List<String> selectUserByPoemId(@Param("id") int id);

    // 根据 id 查询诗歌详情
    @Select("SELECT poems.id, poems.title, poems.content, poems.translation, " +
            "poems.authorId, poets.name as authorName, poems.poemTypeId, " +
            "poem_types.type_name as poemType " +
            "FROM learnpoem.poems " +
            "JOIN poets ON poets.id = poems.authorId " +
            "JOIN poem_types ON poem_types.id = poems.poemTypeId " +
            "WHERE poems.id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "translation", property = "translation"),
            @Result(column = "authorId", property = "authorId"),
            @Result(column = "authorName", property = "authorName"),
            @Result(column = "poemTypeId", property = "poemTypeId"),
            @Result(column = "poemType", property = "poemTypeName")
    })
    Map selectByIdWithPoet(@Param("id") int id);

    // 根据标题查询诗歌详情
    @Select("SELECT * FROM learnpoem.poems WHERE title = #{title}")
    Poem selectByTitle(@Param("title") String title);
    //根据id查询
    @Select("SELECT * FROM learnpoem.poems WHERE id = #{id}")
    Poem selectById(@Param("id") int id);
}