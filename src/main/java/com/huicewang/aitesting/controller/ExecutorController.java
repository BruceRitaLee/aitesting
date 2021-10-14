package com.huicewang.aitesting.controller;

import com.alibaba.fastjson.JSON;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.common.util.SignUtil;
import com.huicewang.aitesting.form.DebugResponseForm;
import com.huicewang.aitesting.form.RequestForm;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.ExecutorService;
import com.huicewang.aitesting.service.RestAssureAssertService;
import com.huicewang.aitesting.service.UserService;
import io.restassured.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "ExecutorController", description = "用户管理")
@RestController
@RequestMapping("/executor")
@CrossOrigin
public class ExecutorController {
    // 定义一个日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorController.class);

    @Autowired
    private ExecutorService executorService;
    @Autowired
    private RestAssureAssertService restAssureAssertService;

    @ApiOperation("执行接口")
    @RequestMapping(value = "/interface", method = RequestMethod.POST)
    public CommonResult executeInterface(@Validated @RequestBody RequestForm requestForm, BindingResult result) {
        // 将json格式的字符串转换成Map对象
        Map<String,Object> mapHeaders = JSON.parseObject(requestForm.getHeaders());
        Map<String,Object> mapParameters = JSON.parseObject(requestForm.getParameters());
        Map<String,Object> mapCookies = JSON.parseObject(requestForm.getCookies());
        //LOGGER.info(mapCookies+mapHeaders+mapParameters);

        Response response = executorService.send(requestForm.getUrl(),mapParameters,mapHeaders,requestForm.getMethod());

        if (response == null){
            LOGGER.error("接口执行出错");
            return CommonResult.failed("请求出现异常，请求方法可能不正确");
        }

        Map<String,Object> responseMap = response.as(Map.class);

        String showUrl = requestForm.getUrl() + "?" + SignUtil.signStringAllParams(mapParameters, "&");
        DebugResponseForm debugResponseForm = new DebugResponseForm();
        debugResponseForm.setDebug(showUrl,response.time(),
                response.asString(),response.getHeaders().toString(),"接口执行成功",
                responseMap, response.getCookies());

        // 接收数据并转换成需要的格式：Map
        // 执行接口
        // 执行结果处理封装，返回到 CommonResult.success(data)
        return CommonResult.success(debugResponseForm);
    }

    @ApiOperation("执行用例")
    @RequestMapping(value = "/case", method = RequestMethod.POST)
    public CommonResult executeCase(@Validated @RequestBody RequestForm requestForm, BindingResult result) {
        // 将json格式的字符串转换成Map对象
        Map<String,Object> mapHeaders = JSON.parseObject(requestForm.getHeaders());
        Map<String,Object> mapParameters = JSON.parseObject(requestForm.getParameters());
        Map<String,Object> mapCookies = JSON.parseObject(requestForm.getCookies());
        String expected = requestForm.getExpected();
        LOGGER.info(expected);

        Response response = executorService.send(requestForm.getUrl(),mapParameters,mapHeaders,requestForm.getMethod());

        if (response == null){
            LOGGER.error("接口执行出错");
            return CommonResult.failed("请求出现异常，请求方法可能不正确");
        }

        Map<String,Object> responseMap = response.as(Map.class);

        String showUrl = requestForm.getUrl() + "?" + SignUtil.signStringAllParams(mapParameters, "&");
        DebugResponseForm debugResponseForm = new DebugResponseForm();
        debugResponseForm.setDebug(showUrl,response.time(),
                response.asString(),response.getHeaders().toString(),"接口执行成功",
                responseMap, response.getCookies());

        try {
            restAssureAssertService.assertRestAssure(response,expected);
        }catch (AssertionError e) {
            //断言失败的信息

            return CommonResult.failed(e.getMessage());
        }

        // 开始断言

        // 接收数据并转换成需要的格式：Map
        // 执行接口
        // 执行结果处理封装，返回到 CommonResult.success(data)
        return CommonResult.success("断言成功");
    }

}
