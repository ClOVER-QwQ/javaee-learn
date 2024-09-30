package com.clover.mapper;

import com.clover.pojo.Poem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PoemMapper {
    @Insert("INSERT INTO learnpoem.poems (title, content, translation, author_id, poem_type_id) VALUES (#{title}, #{content}, #{translation}, #{authorId}, #{poemTypeId})")
    void insert(@Param("title") String title, @Param("content") String content, @Param("translation") String translation, @Param("authorId") int authorId, @Param("poemTypeId") int poemTypeId);

    @Delete("DELETE FROM learnpoem.poems WHERE title = #{title}")
    void deleteByTitle(@Param("title") String title);

    @Select("SELECT * FROM learnpoem.poems WHERE title = #{title}")
    List<Poem> selectByTitle(@Param("title") String title);

    @Select("select * from LearnPoem.poems")
    List<Poem> findAll();
}
