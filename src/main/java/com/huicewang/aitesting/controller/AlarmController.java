package com.huicewang.aitesting.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Alarm;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.AlarmService;
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
@RequestMapping("/alarm")
@Api
@CrossOrigin
public class AlarmController {

    private static  final  Logger logger = LoggerFactory.getLogger(AlarmController.class);

    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到报警信息")
    public CommonResult getAlarmById(@RequestParam("id") int id){
        Alarm alarm= alarmService.getById(id);
        return  CommonResult.success(alarm);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的报警信息")
    public CommonResult insertAlarm(@RequestBody Alarm alarm){
        boolean flag = alarmService.save(alarm);
        if(flag){
            return CommonResult.success(alarm);
        }else{
            return CommonResult.failed();
        }

    }
    @ApiOperation("根据ID 修改报警信息")
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public CommonResult updateAlarmById(@RequestBody Alarm alarm){

        boolean flag = alarmService.updateById(alarm);
        if(flag){
            return  CommonResult.success(alarm);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除报警信息")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteAlarmById(@RequestParam("id") int id){
        boolean flag = alarmService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }
    @RequestMapping(value = "pagelist",method = RequestMethod.GET)
    @ApiOperation("这个是告警分页列表")
    public CommonResult listAlarm(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        Page<Alarm> page = new Page<>(pageNum,pageSize);
        Page<Alarm> alarmPage=alarmService.page(page);
        return CommonResult.success(CommonPage.restResult(alarmPage));

    }




}

