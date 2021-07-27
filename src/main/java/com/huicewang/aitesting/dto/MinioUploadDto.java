package com.huicewang.aitesting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinioUploadDto {
    private String name;
    private String url;

    public void setName(String name) {
        this.name=name;
    }

    public void setUrl(String s) {
        this.url=s;
    }
}
