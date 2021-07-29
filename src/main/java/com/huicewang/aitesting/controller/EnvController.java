package com.huicewang.aitesting.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.ApiCase;
import com.huicewang.aitesting.model.Env;
import com.huicewang.aitesting.service.EnvService;
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
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/env")
@Api
public class EnvController {
    private static  final Logger logger = LoggerFactory.getLogger(EnvController.class);

    @Autowired
    EnvService envService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到环境")
    public CommonResult getEnvById(@RequestParam("id") int id){
        return CommonResult.success(envService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的Env")
    public  CommonResult insertEnv(@RequestBody Env env){
        boolean flag = envService.save(env);
        if(flag){
            return  CommonResult.success(env);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改Env")
    public CommonResult updateEnvById(@RequestBody Env env){
        boolean flag = envService.updateById(env);
        if(flag){
            return  CommonResult.success(env);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Env")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteEnvById(@RequestParam("id") int id ){
        boolean flag = envService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }
    @RequestMapping(value = "envlist",method = RequestMethod.GET)
    @ApiOperation("这个是环境分页列表")
    public CommonResult listEnv(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        Page<Env> page = new Page<>(pageNum,pageSize);
        Page<Env> envPage=envService.page(page);
        return CommonResult.success(CommonPage.restResult(envPage));

    }

}

