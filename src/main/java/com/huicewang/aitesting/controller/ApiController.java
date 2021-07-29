package com.huicewang.aitesting.controller;


import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Api;
import com.huicewang.aitesting.service.ApiService;
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
@RequestMapping("/api")
@io.swagger.annotations.Api
public class ApiController {
    private static  final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    ApiService apiService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到用例")
    public CommonResult getApiById(@RequestParam("id") int id){
        return CommonResult.success(apiService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的API")
    public  CommonResult insertApi(@RequestBody Api api){
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


}

