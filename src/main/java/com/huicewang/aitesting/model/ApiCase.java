package com.huicewang.aitesting.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("apicase")
@ApiModel(value="Apicase对象", description="")
public class ApiCase implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用例id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "接口id")
    @TableField("apiId")
    private Integer apiId;

    @ApiModelProperty(value = "环境id")
    @TableField("envId")
    private Integer envId;

    @ApiModelProperty(value = "用例名")
    private String name;

    @ApiModelProperty(value = "前置处理")
    @TableField("preProcessing")
    private String preProcessing;

    @ApiModelProperty(value = "参数")
    private String params;

    @ApiModelProperty(value = "请求头")
    private String headers;

    @ApiModelProperty(value = "公共参数")
    @TableField("commonParams")
    private String commonParams;

    @ApiModelProperty(value = "预期状态")
    @TableField("expectedStatus")
    private Integer expectedStatus;

    @ApiModelProperty(value = "预期结果")
    @TableField("expectedResult")
    private String expectedResult;

    @ApiModelProperty(value = "后置处理")
    @TableField("postProcessing")
    private String postProcessing;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;

    private String cookies;


}
