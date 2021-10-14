package com.huicewang.aitesting.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author lichong
 * @since 2021-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "api",autoResultMap = true)
@ApiModel(value="Api对象", description="")

public class Api implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "接口id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "接口名")
    private String name;

    @ApiModelProperty(value = "接口版本")
    private String version;

    @ApiModelProperty(value = "接口状态（是否废弃）")
    private Integer status;

    @ApiModelProperty(value = "接口请求类型")
    private String method;

    @ApiModelProperty(value = "接口协议（http或https）")
    private String protocol;

    @ApiModelProperty(value = "接口路径")
    private String path;

    @ApiModelProperty(value = "公共参数")
    @TableField(value = "commonParams",typeHandler = FastjsonTypeHandler.class)
    @JsonFormat(pattern = "{}")
    private String commonParams;

    @ApiModelProperty(value = "接口参数")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    @JsonFormat(pattern = "{}")
    private String params;

    @ApiModelProperty(value = "请求body")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    @JsonFormat(pattern = "{}")
    private String body;

    @ApiModelProperty(value = "请求头")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    @JsonFormat(pattern = "{}")
    private String headers;

    @ApiModelProperty(value = "请求cookie")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    @JsonFormat(pattern = "{}")
    private String cookies;

    @ApiModelProperty(value = "接口描述")
    private String description;

    @ApiModelProperty(value = "返回结果")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    @JsonFormat(pattern = "{}")
    private String response;

    @ApiModelProperty(value = "添加人")
    private String author;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "分组id")
    @TableField("apiGroupId")
    private Integer apiGroupId;

    @ApiModelProperty(value = "接口body请求类型")
    @TableField("requestType")
    private String requestType;


}
