package com.huicewang.aitesting.service.impl;

import com.alibaba.fastjson.JSON;
import com.huicewang.aitesting.service.ExecutorService;
import io.restassured.RestAssured;


import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
@Service
public class ExecutorServiceImpl implements ExecutorService {

    public static void main(String[] args) {
        // 客户端发送信息：json格式的字符串
        String headers = "{\"Accept\":\"application/json\"}";
        String url = "http://121.37.169.128:8201/mall-member/sso/getAuthCode";
        String parameters = "{\"telephone\":\"13401182883\"}";
        String method = "get";


        String expected = "{\"equalTo\":{\"code\":2000,\"message\":\"获取验证码成功\"}}";
//        String expected = "{\"equalTo\":{\"code\":200},\"containsString\":{\"message\":\"获取验证码成功 \"}}";
        // 定义前端发送的数据格式：RequestForm  --》Bean
        //-------------------以上是将要执行的接口信息----------------------------


        Map<String, Object> mapHeaders = JSON.parseObject(headers);
        Map<String, Object> mapParameters = JSON.parseObject(parameters);


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.headers(mapHeaders);
        requestSpecification.formParams(mapParameters);

        Response response = requestSpecification.get(url);


        Map<String, Object> expectedMap = JSON.parseObject(expected);
        Map<String, Object> checkedValue = null;
        for (String key : expectedMap.keySet()) {
            //key = "equalTo"
            if (key.equals("equalTo")) {
                checkedValue = JSON.parseObject(expectedMap.get(key).toString());//{"code":200,"message":"获取验证码成功"}
                for (String subkey : checkedValue.keySet()) {
                    response.then().body(subkey, equalTo(checkedValue.get(subkey).toString()));
                }
            } else if (key.equals("containsString")) {
                checkedValue = JSON.parseObject(expectedMap.get(key).toString());//{"code":200,"message":"获取验证码成功"}
                for (String subkey : checkedValue.keySet()) {
                    response.then().body(subkey, containsString(checkedValue.get(subkey).toString()));
                }
            }
        }

        // 返回的数据内容
        // 定义服务器端执行完成后返回的数据格式：DebugResponseForm ---》Bean



        Map<String,Object> mapPreParameters = new HashMap<>();

        JsonPath jsonPath = new JsonPath(response.body().asString());
        //Map<String,Object> mapPostParameters = JSON.parseObject(postParameters);
//        for(String key:mapPostParameters.keySet()){
//            String regular = mapPostParameters.get(key).toString();
//            String value = jsonPath.get(regular) == null ? "":jsonPath.get(regular);
//
//        }


    }

    public Response send(@NonNull String url, Map<String,Object> params, Map<String,Object> headers, @NonNull String method){
//        RestAssured.config = RestAssuredConfig.config().encoderConfig()
        // 请求设置--预留

        RequestSpecification requestSpecification = RestAssured.given();
        if(headers != null){
            requestSpecification.headers(headers);
        }
        if (params != null) {
            requestSpecification.formParams(params);
        }
        switch (method.toUpperCase()){
            case "GET":
                return requestSpecification.get(url);
            case "PUT" :
                return requestSpecification.put(url);
            case "DELETE" :
                return requestSpecification.delete(url);
            case "POST":
                return requestSpecification.post(url);
            default:
                return null;
        }

    }

}
