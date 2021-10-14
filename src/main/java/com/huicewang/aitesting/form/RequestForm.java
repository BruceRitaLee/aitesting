package com.huicewang.aitesting.form;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class RequestForm {
    //private Integer projectId;

    @NotBlank(message = "请求地址不能为空！")
    //@Pattern(regexp = "^((ht|f)tp?):\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-\\.,@?^=%&:\\/~\\+#]*[\\w\\-\\@?^=%&\\/~\\+#])?$")
    private String url;

    private String parameters;

    public String getUrl() {
        return url;
    }

    public String getParameters() {
        return parameters;
    }

    public String getMethod() {
        return method;
    }

    public String getHeaders() {
        return headers;
    }

    public String getCookies() {
        return cookies;
    }

    public String getExpected(){return expected;}

    private String expected;

    //public Integer getProjectId() {
       // return projectId;
   // }

    @NotBlank(message = "请求方法不能为空！")
    private String method;
    private String headers;
    private String cookies;
}
