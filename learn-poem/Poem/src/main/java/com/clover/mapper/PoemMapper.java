package com.clover.mapper;

import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PoemMapper {
    int pageNumber = 1; // 页码
    int pageSize = 5; // 每页条数
    int offset = (pageNumber - 1) * pageSize;

    // 批量插入诗歌
    @Insert({"INSERT INTO learnpoem.poems (title, content, translation, authorId, poemTypeId) VALUES (#{title}, #{content}, #{translation}, #{authorId}, #{poemTypeId})"})
    void insertByPoem(Poem poem1);
    @Insert("<script> INSERT INTO learnpoem.poems (title, content, translation, authorId, poemTypeId) VALUES <foreach collection='list' item='poem' separator=','> (#{poem.title}, #{poem.content}, #{poem.translation}, #{poem.authorId}, #{poem.poemTypeId}) </foreach> </script>")
    void batchInsert(List<Poem> poems);
    @Insert("INSERT INTO learnpoem.poems (title, content, translation, authorId, poemTypeId) VALUES (#{title}, #{content}, #{translation}, #{authorId}, #{poemTypeId})")
    void insert(@Param("title") String title, @Param("content") String content, @Param("translation") String translation, @Param("authorId") int authorId, @Param("poemTypeId") int poemTypeId);

    // 根据id删除诗歌记录
    @Delete("<script> DELETE FROM learnpoem.poems WHERE id IN <foreach collection='list' item='id' open='(' separator=',' close=')'> #{id} </foreach> </script>")
    void batchDeleteByIds(List<Integer> ids);
    @Delete("DELETE FROM learnpoem.poems WHERE id = #{id}")
    void deleteById(@Param("id") int id);
    @Delete("DELETE FROM learnpoem.poems WHERE title = #{title}")
    void deleteByTitle(@Param("title") String title);

    @Update("UPDATE learnpoem.poems SET title = #{title}, content = #{content}, translation = #{translation}, authorId = #{authorId}, poemTypeId = #{poemTypeId} WHERE id = #{id}")
    void updateById(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("translation") String translation, @Param("authorId") int authorId, @Param("poemTypeId") int poemTypeId);
    @Update("UPDATE learnpoem.poems SET title = #{title} WHERE id = #{id}")
    void updateTitleById(@Param("id") int id,@Param("title") String title);

    // 根据id查询诗歌记录，添加分页参数
    @Select("SELECT poems.collectedCount FROM poems WHERE poems.id = #{id} LIMIT #{offset}, #{limit}")
    int selectCollectionById(@Param("id") int id, @Param("offset") int offset, @Param("limit") int limit);

    // 根据诗歌 id 查询收藏该诗歌的用户列表，并进行分页
    @Select("SELECT users.username FROM collections JOIN poems ON poems.id = collections.resource_id JOIN users ON users.id = collections.user_id WHERE poems.id = #{id} LIMIT #{offset}, #{limit}")
    List<String> selectUserById(@Param("id") int id, @Param("offset") int offset, @Param("limit") int limit);

    // 根据 id 查询诗歌详情，并进行分页
    @Select("SELECT poems.id,poems.title,poems.content,poems.translation,poems.authorId,poets.name as authorName,poems.poemTypeId,poem_types.type_name as poemType FROM learnpoem.poems JOIN poets ON poets.id = poems.authorId JOIN poem_types ON poem_types.id = poems.poemTypeId WHERE poems.id = #{id} LIMIT #{offset}, #{limit}")
    Poem selectById(@Param("id") int id, @Param("offset") int offset, @Param("limit") int limit);

    // 根据标题查询诗歌详情，并进行分页
    @Select("SELECT poems.id,poems.title,poems.content,poems.translation,poems.authorId,poets.name as authorName,poems.poemTypeId,poem_types.type_name as poemType FROM learnpoem.poems JOIN poets ON poets.id = poems.authorId JOIN poem_types ON poem_types.id = poems.poemTypeId WHERE poems.title = #{title} LIMIT #{offset}, #{limit}")
    Poem selectByTitle(@Param("title") String title, @Param("offset") int offset, @Param("limit") int limit);

    // 查询作者，并进行分页
    @Select("SELECT poets.* FROM poets JOIN poems ON poems.authorId = poets.id WHERE poems.id = #{id} LIMIT #{offset}, #{limit}")
    Poet selectPoetById(@Param("id") int id, @Param("offset") int offset, @Param("limit") int limit);

    // 查询所有诗歌，并进行分页
    @Select("SELECT poems.id,poems.title,poems.content,poems.translation,poems.authorId,poets.name as authorName,poems.poemTypeId,poem_types.type_name as poemType FROM learnpoem.poems JOIN poets ON poets.id = poems.authorId JOIN poem_types ON poem_types.id = poems.poemTypeId LIMIT #{offset}, #{limit}")
    List<Poem> findAll(@Param("offset") int offset, @Param("limit") int limit);
}