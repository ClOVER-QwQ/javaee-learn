package com.clover.controller.impl;

import com.clover.controller.PoemController;
import com.clover.pojo.Poem;
import com.clover.pojo.Poet;
import com.clover.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController("poemController")
@RequestMapping("poem")
public class PoemControllerImpl implements PoemController {
    @Autowired
    private PoemService poemService;
    @Override
    @PostMapping("insert")
    public int insertByPoem(@RequestBody Poem poem) {
        return poemService.insertByPoem(poem);
    }

    @Override
    @PostMapping("batchInsert")
    public int batchInsert(@RequestBody List<Poem> poems) {
        return poemService.batchInsert(poems);
    }

    @Override
    @DeleteMapping("batchDelete")
    public int batchDeleteByIds(@RequestParam("id") List<Integer> ids) {
        return poemService.batchDeleteByIds(ids);
    }

    @Override
    @DeleteMapping("delete/{id}")
    public int deleteById(@PathVariable("id") int id) {
        return poemService.deleteById(id);
    }

    @Override
    @DeleteMapping("delete2/{title}")
    public int deleteByTitle(@PathVariable("title") String title) {
        return poemService.deleteByTitle(title);
    }

    @Override
    @PutMapping("update")
    public int updateById(@RequestBody Poem poem) {
        return poemService.updateById(poem.getId(),poem.getTitle(),poem.getContent(),poem.getTranslation(),poem.getAuthorId(),poem.getPoemTypeId());
    }

    @Override
    public int updateTitleById(int id, String title) {
        return 0;
    }

    @Override
    @GetMapping("selectPoetByPoemId/{id}")
    public Poet selectPoetByPoemId(@PathVariable("id") int id) {
        return poemService.selectPoetByPoemId(id);
    }

    @Override
    @GetMapping("select")
    public List<Poem> selectAll(@RequestParam("num") int pageNum, @RequestParam("size") int pageSize) {
        return poemService.selectAll(pageNum,pageSize);
    }


    @Override
    @GetMapping("selectCollectorCountById/{id}")
    public int selectCollectorCountById(@PathVariable("id") int poemId) {
        return poemService.selectCollectorCountById(poemId);
    }

    @Override
    @GetMapping("selectByMulti")
    public List<Poem> selectByMulti(@RequestParam String content, @RequestParam int pageNum,@RequestParam int pageSize) {
        List<Poem> poems = poemService.selectByMulti(content,pageNum,pageSize);
        return poems;
    }

    @Override
    @GetMapping(" selectUserByPoemId")
    public List<String> selectUserByPoemId(@RequestParam int id,@RequestParam int pageNum,@RequestParam int pageSize) {
        List<String> users = poemService.selectUserByPoemId(id,pageNum,pageSize);
        return users;
    }

    @Override
    @GetMapping("selectByIdWithPoet/{id}")
    public Map<String, Object> selectByIdWithPoet(@PathVariable("id") int id) {
        return poemService.selectByIdWithPoet(id);
    }

    @Override
    @GetMapping("selectByTitle/{title}")
    public Poem selectByTitle(@PathVariable("title") String title) {
        return poemService.selectByTitle(title);
    }

    @Override
    @GetMapping("selectById")
    public Poem selectById(int id) {
        return poemService.selectById(id);
    }
}
