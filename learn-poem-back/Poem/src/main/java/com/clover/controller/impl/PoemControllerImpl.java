package com.clover.controller.impl;

import com.clover.controller.PoemController;
import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import com.clover.service.PoemService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("poemController")
@RequestMapping("poem")
public class PoemControllerImpl implements PoemController {
    @Autowired
    private PoemService poemService;
    @Override
    @ResponseBody
    @PostMapping("insertByPoem")
    public int insertByPoem(@RequestBody Poem poem) {
        return poemService.insertByPoem(poem);
    }

    @Override
    @ResponseBody
    @PostMapping("batchInsert")
    public int batchInsert(@RequestBody List<Poem> poems) {
        return poemService.batchInsert(poems);
    }

    @Override
    @ResponseBody
    @DeleteMapping("batchDeleteByIds")
    public int batchDeleteByIds(@RequestParam("id") List<Integer> ids) {
        return poemService.batchDeleteByIds(ids);
    }

    @Override
    @ResponseBody
    @DeleteMapping("deleteById/{id}")
    public int deleteById(@PathVariable("id") int id) {
        return poemService.deleteById(id);
    }

    @Override
    @ResponseBody
    @DeleteMapping("deleteByTitle/{title}")
    public int deleteByTitle(@PathVariable("title") String title) {
        return poemService.deleteByTitle(title);
    }

    @Override
    @ResponseBody
    @PutMapping("updateById")
    public int updateById(@RequestParam("id") int id, @RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("translation") String translation,@RequestParam("authorId") int authorId,@RequestParam("poemTypeId") int poemTypeId) {
        return poemService.updateById(id,title,content,translation,authorId,poemTypeId);
    }

    @Override
    public int updateTitleById(int id, String title) {
        return 0;
    }

    @Override
    @ResponseBody
    @GetMapping("selectPoetByPoemId/{id}")
    public Poet selectPoetByPoemId(@PathVariable("id") int id) {
        return poemService.selectPoetByPoemId(id);
    }

    @Override
    @ResponseBody
    @GetMapping("selectAll")
    public List<Poem> selectAll(@RequestParam("num") int pageNum,@RequestParam("size") int pageSize) {
        return poemService.selectAll(pageNum,pageSize);
    }


    @Override
    @ResponseBody
    @GetMapping("selectCollectorCountById/{id}")
    public int selectCollectorCountById(@PathVariable("id") int poemId) {
        return poemService.selectCollectorCountById(poemId);
    }

    @Override
    @ResponseBody
    @GetMapping("selectByMulti")
    public List<Poem> selectByMulti(@RequestParam String content, @RequestParam int pageNum,@RequestParam int pageSize) {
        List<Poem> poems = poemService.selectByMulti(content,pageNum,pageSize);
        return poems;
    }

    @Override
    @ResponseBody
    @GetMapping(" selectUserByPoemId")
    public List<String> selectUserByPoemId(@RequestParam int id,@RequestParam int pageNum,@RequestParam int pageSize) {
        List<String> users = poemService.selectUserByPoemId(id,pageNum,pageSize);
        return users;
    }

    @Override
    @ResponseBody
    @GetMapping("selectByIdWithPoet/{id}")
    public Map<String, Object> selectByIdWithPoet(@PathVariable("id") int id) {
        return poemService.selectByIdWithPoet(id);
    }

    @Override
    @ResponseBody
    @GetMapping("selectByTitle/{title}")
    public Poem selectByTitle(@PathVariable("title") String title) {
        return poemService.selectByTitle(title);
    }

    @Override
    @ResponseBody
    @GetMapping("selectById")
    public Poem selectById(int id) {
        return poemService.selectById(id);
    }
}
