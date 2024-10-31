package com.clover.service;

import com.clover.pojo.Poem;

public interface PoemService {
    void insertByPoem(Poem poem);
    void deleteByTitle(String title);
    void updateTitleById(int id,String title);
}
