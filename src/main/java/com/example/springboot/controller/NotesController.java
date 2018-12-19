package com.example.springboot.controller;

import com.example.springboot.common.NotesEx;
import com.example.springboot.entity.Notes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-19
 * @Time 下午5:05
 */
@RestController
@RequestMapping("/api/notes")
@Api(value = "notes", tags = "Notes", description = "文章操作")
public class NotesController extends BaseController implements NotesEx {

    Logger logger = LoggerFactory.getLogger(NotesController.class);

    @ApiOperation("创建文章")
    @PostMapping("/addNote")
    @Override
    public String addNote(Notes note) {
        logger.info("addNote : " + note.toString());

        return null;
    }

    @ApiOperation("通过文章id删除文章")
    @ApiImplicitParam(name = "ids", value = "文章Id", allowMultiple=true, required = true, dataType = "Long")
    @DeleteMapping("/deleteNotesById")
    @Override
    public String deleteNotesById(Long... ids) {
        return null;
    }

    @ApiOperation("修改文章")
    @PutMapping("/updateNote")
    @Override
    public String updateNote(Notes note) {
        return null;
    }

    @ApiOperation("获取全部文章列表")
    @GetMapping("/getAllNotes")
    @Override
    public List<Notes> getAllNotes() {
        return null;
    }

    @ApiOperation("跟根据文章id获取文章信息")
    @ApiImplicitParam(name = "ids", value = "文章Id", allowMultiple=true, required = true, dataType = "Long")
    @GetMapping("/getNotesById")
    @Override
    public List<Notes> getNotesById(@RequestParam Long... ids) {
        logger.info(Arrays.toString(ids));
        return null;
    }

}
