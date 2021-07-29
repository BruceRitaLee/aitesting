package com.huicewang.aitesting.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Alarm;
import com.huicewang.aitesting.model.ApiCase;
import com.huicewang.aitesting.service.ApiCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichong
 * @since 2021-07-27
 */
@RestController
@RequestMapping("/apicase")
@Api
public class ApiCaseController {
    private static  final Logger logger = LoggerFactory.getLogger(ApiCaseController.class);

    @Autowired
    ApiCaseService apiCaseService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到用例")
    public CommonResult getApiById(@RequestParam("id") int id){
        return CommonResult.success(apiCaseService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的APIcase")
    public  CommonResult insertApiCase(@RequestBody ApiCase apicase){
        boolean flag = apiCaseService.save(apicase);
        if(flag){
            return  CommonResult.success(apicase);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改apicase")
    public CommonResult updateApiCaseById(@RequestBody ApiCase apicase){
        boolean flag = apiCaseService.updateById(apicase);
        if(flag){
            return  CommonResult.success(apicase);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Apicase")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteApiCaseById(@RequestParam("id") int id ){
        boolean flag = apiCaseService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }
    @RequestMapping(value = "caselist",method = RequestMethod.GET)
    @ApiOperation("这个是api用例分页列表")
    public CommonResult listApiCase(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        Page<ApiCase> page = new Page<>(pageNum,pageSize);
        Page<ApiCase> casePage=apiCaseService.page(page);
        return CommonResult.success(CommonPage.restResult(casePage));

    }

}

