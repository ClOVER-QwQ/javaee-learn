package com.clover.Service;

import com.clover.pojo.Poem;

import java.util.List;

public interface PoemService {

    List<Poem> selectByTitle();
}
