package com.huicewang.aitesting.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class DebugResponseForm {
    private String url;
    private long time;
    private String response;
    private String headers;
    private String message;
    private Map<String,Object> responseMap;
    private Map<String,String> cookies;

    public void setDebug(String url, long time, String response, String headers, String message){
        this.url = url;
        this.time = time;
        this.response = response;
        this.headers = headers;
        this.message = message;
    }
    public void setDebug(String url, long time, String response, String headers, String message, Map<String,Object> responseMap, Map<String,String> cookies){
        this.url = url;
        this.time = time;
        this.response = response;
        this.headers = headers;
        this.message = message;
        this.responseMap = responseMap;
        this.cookies = cookies;
    }
}
