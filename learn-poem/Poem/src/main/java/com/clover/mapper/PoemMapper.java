package com.clover.mapper;

import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PoemMapper {
    @Insert("INSERT INTO learnpoem.poems (title, content, translation, authorId, poemTypeId) VALUES (#{title}, #{content}, #{translation}, #{authorId}, #{poemTypeId})")
    void insert(@Param("title") String title, @Param("content") String content, @Param("translation") String translation, @Param("authorId") int authorId, @Param("poemTypeId") int poemTypeId);

    // 根据id删除诗歌记录
    @Delete("DELETE FROM learnpoem.poems WHERE id = #{id}")
    void deleteById(@Param("id") int id);
    @Delete("DELETE FROM learnpoem.poems WHERE title = #{title}")
    void deleteByTitle(@Param("title") String title);

    @Update("UPDATE learnpoem.poems SET title = #{title}, content = #{content}, translation = #{translation}, authorId = #{authorId}, poemTypeId = #{poemTypeId} WHERE id = #{id}")
    void updateById(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("translation") String translation, @Param("authorId") int authorId, @Param("poemTypeId") int poemTypeId);
    @Update("UPDATE learnpoem.poems SET title = #{title} WHERE id = #{id}")
    void updateTitleById(@Param("id") int id,@Param("title") String title);

    // 根据id查询诗歌记录
    @Select("SELECT poems.collectedCount FROM poems WHERE poems.id = #{id}")
    int selectCollectionById(@Param("id") int id);
    @Select("SELECT users.username FROM collections JOIN poems ON poems.id = collections.resource_id JOIN users ON users.id = collections.user_id WHERE poems.id = #{id}")
    List<String> selectUserById(@Param("id") int id);
    @Select("SELECT poems.id,poems.title,poems.content,poems.translation,poems.authorId,poets.name as authorName,poems.poemTypeId,poem_types.type_name as poemType FROM learnpoem.poems JOIN poets ON poets.id = poems.authorId JOIN poem_types ON poem_types.id = poems.poemTypeId WHERE poems.id = #{id}")
    Poem selectById(@Param("id") int id);
    @Select("SELECT poems.id,poems.title,poems.content,poems.translation,poems.authorId,poets.name as authorName,poems.poemTypeId,poem_types.type_name as poemType FROM learnpoem.poems JOIN poets ON poets.id = poems.authorId JOIN poem_types ON poem_types.id = poems.poemTypeId WHERE poems.title = #{title}")
    Poem selectByTitle(@Param("title") String title);
    //查询作者
    @Select("SELECT poets.* FROM poets JOIN poems ON poems.authorId = poets.id WHERE poems.id = #{id}")
    Poet selectPoetById(@Param("id") int id);
    // 查询所有诗歌记录
    @Select("SELECT poems.id,poems.title,poems.content,poems.translation,poems.authorId,poets.name as authorName,poems.poemTypeId,poem_types.type_name as poemType FROM learnpoem.poems JOIN poets ON poets.id = poems.authorId JOIN poem_types ON poem_types.id = poems.poemTypeId")
    List<Poem> findAll();
}