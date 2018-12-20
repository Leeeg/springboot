package com.example.springboot.controller;

import com.example.springboot.controller.presenter.NotesPresenter;
import com.example.springboot.dto.Response;
import com.example.springboot.entity.Notes;
import com.example.springboot.service.impl.NotesServiceImpl;
import com.example.springboot.util.ResponseEnum;
import com.example.springboot.util.response.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-19
 * @Time 下午5:05
 */
@RestController
@RequestMapping("/api/notes")
@Api(value = "/notes", tags = "Notes", description = "文章操作")
public class NotesController extends BaseController implements NotesPresenter {

    Logger logger = LoggerFactory.getLogger(NotesController.class);

    @Autowired
    NotesServiceImpl notesService;

    @ApiOperation("创建文章")
    @PostMapping("/addNote")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", dataType = "String"),
            @ApiImplicitParam(name = "isPrivate", value = "是否私有", dataType = "Boolean"),
            @ApiImplicitParam(name = "type", value = "文章分类", dataType = "Byte", example = "0")
    })
    @Override
    public Response addNote(String title, String content, Boolean isPrivate, Byte type) {
        logger.info("addNote : "
                + " \ntitle = " + title
                + " \ncontent = " + content
                + " \nisPrivate = " + isPrivate
                + " \ntype = " + type
        );

        int result = notesService.addNote(title, content, isPrivate, type);
        if (0 == result) {
            return ResponseUtil.error(ResponseEnum.UNKNOWN_ERROR);
        }
        return ResponseUtil.success("addNote : " + result);
    }

    @ApiOperation("通过文章id删除文章")
    @ApiImplicitParam(name = "ids", value = "文章Id", allowMultiple = true, required = true, dataType = "Long")
    @DeleteMapping("/deleteNotesById")
    @Override
    public Response deleteNotesById(Long... ids) {
        logger.info("deleteNotesById : " + Arrays.toString(ids));
        return null;
    }

    @ApiOperation("修改文章")
    @PutMapping("/updateNote")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", dataType = "String"),
            @ApiImplicitParam(name = "isPrivate", value = "是否私有", dataType = "Boolean"),
            @ApiImplicitParam(name = "type", value = "文章分类", dataType = "Byte", example = "0")
    })
    @Override
    public Response updateNote(String title, String content, Boolean isPrivate, Byte type) {
        logger.info("addNote : "
                + " \ntitle = " + title
                + " \ncontent = " + content
                + " \nisPrivate = " + isPrivate
                + " \ntype = " + type
        );
        int result = notesService.updateNote(title, content, isPrivate, type);
        if (0 == result) {
            return ResponseUtil.error(ResponseEnum.UNKNOWN_ERROR);
        }
        return ResponseUtil.success("update " + result);
    }

    @ApiOperation("获取全部文章列表")
    @GetMapping("/getAllNotes")
    @Override
    public Response getAllNotes() {

        return ResponseUtil.success(notesService.getAllNotes());
    }

    @ApiOperation("跟根据文章id获取文章信息")
    @ApiImplicitParam(name = "ids", value = "文章Id", allowMultiple = true, required = true, dataType = "Long")
    @GetMapping("/getNotesById")
    @Override
    public Response getNotesById(@RequestParam Long... ids) {
        logger.info("getNotesById : " + Arrays.toString(ids));
        return ResponseUtil.success(notesService.getNotesById(ids));
    }

}
