package com.huicewang.aitesting.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("api")
@ApiModel(value="Api对象", description="")
public class Api implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "接口id")
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
    @TableField("commonParams")
    private String commonParams;

    @ApiModelProperty(value = "接口参数")
    private String params;

    @ApiModelProperty(value = "请求body")
    private String body;

    @ApiModelProperty(value = "请求头")
    private String headers;

    @ApiModelProperty(value = "请求cookie")
    private String cookies;

    @ApiModelProperty(value = "接口描述")
    private String description;

    @ApiModelProperty(value = "返回结果")
    private String response;

    @ApiModelProperty(value = "添加人")
    private String author;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "分组id")
    @TableField("apiGroupId")
    private Integer apiGroupId;


}
