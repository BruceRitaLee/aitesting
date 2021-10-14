package com.huicewang.aitesting.service.impl;

import com.alibaba.fastjson.JSON;
import com.huicewang.aitesting.controller.ExecutorController;
import com.huicewang.aitesting.service.RestAssureAssertService;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasValue;

@Service
public class RestAssureAssertServiceImpl implements RestAssureAssertService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestAssureAssertServiceImpl.class);
    public void assertRestAssure(Response response, String expected) {
        Map<String, Object> expectedMap = JSON.parseObject(expected);
        LOGGER.info(String.valueOf(expectedMap));
        Map<String, Object> checkedValue = null;
        for (String key : expectedMap.keySet()) {
            //key = "equalTo"
            if (key.equals("equalTo")) {
                checkedValue = JSON.parseObject(expectedMap.get(key).toString());//{"code":200,"message":"获取验证码成功"}
                for (String subkey : checkedValue.keySet()) {
                    response.then().body(subkey, equalTo(checkedValue.get(subkey)));
                }
            } else if (key.equals("containsString")) {
                checkedValue = JSON.parseObject(expectedMap.get(key).toString());//{"code":200,"message":"获取验证码成功"}
                for (String subkey : checkedValue.keySet()) {
                    response.then().body(subkey, containsString(checkedValue.get(subkey).toString()));
                }
            }
            //list包含校验，必须等于list中某项，且相等
            else if (key.equals("hasItem")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, hasItem(checkedValue.get(subKey)));
                }
            }
            //list包含校验，必须包含list中某项，且是包含关系
            else if (key.equals("hasItemOrContainsString")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, hasItem(containsString(checkedValue.get(subKey).toString())));
                }
            }
            //是否以什么开始
            else if (key.equals("startsWith")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, startsWith((checkedValue.get(subKey).toString())));
                }
            }
            //是否以什么结尾
            else if (key.equals("endsWith")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, endsWith((checkedValue.get(subKey).toString())));
                }
            }
            //小于或等于校验
            else if (key.equals("lessThanOrEqualTo")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, lessThanOrEqualTo(Integer.valueOf(checkedValue.get(subKey).toString())));
                }
            }
            //大于或等于校验
            else if (key.equals("greaterThanOrEqualTo")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, greaterThanOrEqualTo(Integer.valueOf(checkedValue.get(subKey).toString())));
                }
            }
            //数组长度
            else if (key.equals("hasSize")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, hasSize(Integer.valueOf(checkedValue.get(subKey).toString())));
                }
            }
            //是否有key
            else if (key.equals("hasKey")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, hasKey(equalTo(checkedValue.get(subKey))));
                }
            }
            //是否有value值
            else if (key.equals("hasValue")) {
                for (String subKey : checkedValue.keySet()) {
                    response.then().body(subKey, hasValue(equalTo(checkedValue.get(subKey))));
                }
            }
        }
    }
}