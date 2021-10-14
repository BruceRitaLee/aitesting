package com.huicewang.aitesting.form;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @program: aitesting
 * @author: caosenquan
 * @create: 2021-08-22 11:29
 **/

public class ApiForm {


    private Integer id;

    private String name;

    private String version;

    private Integer status;

    private String method;

    private String protocol;

    private String path;

    private String commonParams;

    private String params;

    private String body;

    private String headers;

    private String cookies;

    private String description;

    private String response;


    private String author;

    private Date createTime;

    private Date updateTime;

    private Integer apiGroupId;


    private Integer projectId;



    private int pageIndex;
    private int pageSize;

    @Override
    public String toString() {
        return "ApiForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", status=" + status +
                ", method='" + method + '\'' +
                ", protocol='" + protocol + '\'' +
                ", path='" + path + '\'' +
                ", commonParams='" + commonParams + '\'' +
                ", params='" + params + '\'' +
                ", body='" + body + '\'' +
                ", headers='" + headers + '\'' +
                ", cookies='" + cookies + '\'' +
                ", description='" + description + '\'' +
                ", response='" + response + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", apiGroupId=" + apiGroupId +
                ", projectId=" + projectId +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCommonParams() {
        return commonParams;
    }

    public void setCommonParams(String commonParams) {
        this.commonParams = commonParams;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getApiGroupId() {
        return apiGroupId;
    }

    public void setApiGroupId(Integer apiGroupId) {
        this.apiGroupId = apiGroupId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
