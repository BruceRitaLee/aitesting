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
@TableName("env")
@ApiModel(value="Env对象", description="")
public class Env implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "环境id")
    private Integer id;

    @ApiModelProperty(value = "环境名")
    private String name;

    @ApiModelProperty(value = "服务")
    private String service;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;

    @TableField("projectId")
    private Integer projectId;


}
