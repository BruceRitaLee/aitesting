package com.huicewang.aitesting.service;

import io.restassured.response.Response;
import org.springframework.lang.NonNull;

import java.util.Map;

public interface ExecutorService {
    Response send(@NonNull String url, Map<String,Object> params, Map<String,Object> headers, @NonNull String method);

}
