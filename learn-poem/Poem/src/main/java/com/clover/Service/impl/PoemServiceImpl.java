package com.clover.Service.impl;

import com.clover.Service.PoemService;
import com.clover.pojo.Poem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemServiceImpl implements PoemService {

    @Override
    public List<Poem> selectByTitle() {
        return null;
    }
}
