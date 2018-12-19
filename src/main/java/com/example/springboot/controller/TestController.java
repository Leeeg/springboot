package com.example.springboot.controller;

import com.example.springboot.entity.SortInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @title:
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/11/9
 */
@RestController
@RequestMapping("/test")
@Api(value = "Test", tags = "Test", description = "测试restful")
public class TestController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 获取所有分类信息
     *
     * @return
     */
    @ApiOperation(value = "获取所有分类信息", notes = "获取所有分类信息")
    @GetMapping("/getSortList")
    public SortInfo getSortList() {
        logger.info("getSortList");
        SortInfo sortInfo = new SortInfo();
        sortInfo.setId(new Random().nextLong());
        sortInfo.setName("sortName");
        sortInfo.setIsEffective(true);
        return sortInfo;
    }

    /**
     * 通过id获取一条分类信息
     *
     * @param id
     * @return
     */
    @ApiOperation("获取某一条分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long", example = "0")
    @GetMapping("/getSortInfoById/{id}")
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
    @ApiImplicitParam(name="sortInfo", value="SortInfo", required = true, dataType = "SortInfo")
    @PostMapping("/addSortInfo")
    public SortInfo addSortInfo(SortInfo sortInfo) {
        logger.info("addSortInfo : " + sortInfo.toString());
        return sortInfo;
    }

    /**
     * 更新/编辑一条数据
     *
     * @param id
     * @return
     */
    @ApiOperation("更新/编辑分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long", example = "0")
    @PutMapping("/updateSortInfo/{id}")
    public String updateSortInfo(@PathVariable Long id) {
        logger.info("updateSortInfo id = " + id);
        return "update success!";
    }

    /**
     * 根据ID删除分类信息
     *
     * @param id
     * @return
     */
    @ApiOperation("删除分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long", example = "0")
    @DeleteMapping("/deleteSortInfo/{id}")
    public String deleteSortInfo(@PathVariable Long id) {
        logger.info("deleteSortInfo id = " + id);
        return "delete success!";
    }
}
