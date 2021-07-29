package com.huicewang.aitesting.controller;


import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Params;
import com.huicewang.aitesting.service.ParamsService;
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
 * @since 2021-07-29
 */
@RestController
@RequestMapping("/params")
@Api
public class ParamsController {
    private static  final Logger logger = LoggerFactory.getLogger(ParamsController.class);

    @Autowired
    ParamsService paramsService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到环境")
    public CommonResult getParamsById(@RequestParam("id") int id){
        return CommonResult.success(paramsService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的Params")
    public  CommonResult insertParams(@RequestBody Params Params){
        boolean flag = paramsService.save(Params);
        if(flag){
            return  CommonResult.success(Params);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改Params")
    public CommonResult updateParamsById(@RequestBody Params Params){
        boolean flag = paramsService.updateById(Params);
        if(flag){
            return  CommonResult.success(Params);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Params")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteParamsById(@RequestParam("id") int id ){
        boolean flag = paramsService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }

}

