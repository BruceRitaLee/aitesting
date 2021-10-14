package com.huicewang.aitesting.service;

import io.restassured.response.Response;

public interface RestAssureAssertService {
    void assertRestAssure(Response response, String expected);
}
