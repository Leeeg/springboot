package com.example.springboot.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @title:
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/11/9
 */
@RestController
@RequestMapping("/api/test")
public class TestController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 获取所有分类信息
     *
     * @return
     */
    @ApiOperation("获取所有分类信息")
    @GetMapping("/getSortList")
    public String getSortList() {
        logger.info("getSortList");
        return null;
    }

    /**
     * 通过id获取一条分类信息
     *
     * @param id
     * @return
     */
    @ApiOperation("获取某一条分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public String getSortInfoById(@PathVariable Long id) {
        logger.info("getSortInfoById id = " + id);
        return null;
    }

    /**
     * 增加一条分类信息数据
     *
     * @return
     */
    @ApiOperation("增加分类信息")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
    @PostMapping("/addSortInfo")
    public String addSortInfo(String name) {
        logger.info("addSortInfo name = " + name);
        return null;
    }

    /**
     * 更新/编辑一条数据
     *
     * @param id
     * @return
     */
    @ApiOperation("更新/编辑分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
    @PutMapping("/{id}")
    public String updateSortInfo(@PathVariable Long id) {
        logger.info("updateSortInfo id = " + id);
        return null;
    }

    /**
     * 根据ID删除分类信息
     *
     * @param id
     * @return
     */
    @ApiOperation("删除分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public String deleteSortInfo(@PathVariable Long id) {
        logger.info("deleteSortInfo id = " + id);
        return null;
    }
}
