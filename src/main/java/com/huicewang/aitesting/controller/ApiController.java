package com.huicewang.aitesting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Api;
import com.huicewang.aitesting.model.ApiCase;
import com.huicewang.aitesting.model.ApiGroup;
import com.huicewang.aitesting.service.ApiGroupService;
import com.huicewang.aitesting.service.ApiService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichong
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/api")
@io.swagger.annotations.Api
@CrossOrigin
public class ApiController {
    private static  final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    ApiService apiService;
    @Autowired
    ApiGroupService apiGroupService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到用例")
    public CommonResult getApiById( @RequestParam("id") int id ){

        return CommonResult.success(apiService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的API")
    public  CommonResult insertApi(@Validated @RequestBody Api api,BindingResult result){
        boolean flag = apiService.save(api);
        if(flag){
            return  CommonResult.success(api);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改api")
    public CommonResult updateApiById(@RequestBody Api api){
        boolean flag = apiService.updateById(api);
        if(flag){
            return  CommonResult.success(api);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Api")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteApiById(@RequestParam("id") int id ){
        boolean flag = apiService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }
    @RequestMapping(value = "apilist",method = RequestMethod.GET)
    @ApiOperation("这个是api分页列表")
    public CommonResult listApi(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                @RequestParam(value = "apiGroupId",required = false) Integer apiGroup,
                                @RequestParam(value = "id",required = false) Integer id,
                                @RequestParam(value = "projectId",required = false) Integer projectId) {
        Page<Api> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ApiGroup> queryWrapper = new QueryWrapper();
        List<Object> apiG = new ArrayList<>();

        if(projectId!=null){
            queryWrapper.eq("projectId", projectId);
            apiG = apiGroupService.listObjs(queryWrapper);
        }
        QueryWrapper<Api> queryWrapper1 = new QueryWrapper();
        if(apiGroup!=null){
            queryWrapper1.eq("apiGroupId",apiGroup);
        }else{
            if(apiG.size()>0){
                //logger.info(String.valueOf(apiG));
        queryWrapper1.in("apiGroupId",apiG);
            }
        }
        if(id!=null){
            queryWrapper1.eq("id",id);
        }
        if(projectId==null&&apiGroup==null&&id==null){
            return CommonResult.failed();
        }
        Page<Api> apiPage= apiService.page(page,queryWrapper1);

        return CommonResult.success(CommonPage.restResult(apiPage));
    }
}
