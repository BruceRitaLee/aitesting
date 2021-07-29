package com.huicewang.aitesting.controller;


import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Apigroup;
import com.huicewang.aitesting.service.ApiGroupService;
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
@RequestMapping("/apigroup")
@Api
public class ApigroupController {
    private static  final Logger logger = LoggerFactory.getLogger(ApigroupController.class);

    @Autowired
    ApiGroupService apigroupService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到用例组")
    public CommonResult getApigroupById(@RequestParam("id") int id){
        return CommonResult.success(apigroupService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的APIgroup")
    public  CommonResult insertApiGroup(@RequestBody Apigroup apigroup){
        boolean flag = apigroupService.save(apigroup);
        if(flag){
            return  CommonResult.success(apigroup);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改apigroup")
    public CommonResult updateApiGroupById(@RequestBody Apigroup apigroup){
        boolean flag = apigroupService.updateById(apigroup);
        if(flag){
            return  CommonResult.success(apigroup);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Apigroup")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteApiGroupById(@RequestParam("id") int id ){
        boolean flag = apigroupService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }


}

