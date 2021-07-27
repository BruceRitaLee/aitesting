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
@TableName("task")
@ApiModel(value="Task对象", description="")
public class Task implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "任务id")
    private Integer id;

    @ApiModelProperty(value = "任务名")
    private String name;

    @ApiModelProperty(value = "任务表达式")
    private String task;

    @ApiModelProperty(value = "任务描述")
    private String description;

    @ApiModelProperty(value = "任务状态")
    @TableField("jobStatus")
    private String jobStatus;

    @ApiModelProperty(value = "cron")
    private String cron;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "添加人员")
    private String author;

    @ApiModelProperty(value = "报警类型（0 关闭 1 开启）")
    @TableField("alarmSwitch")
    private Integer alarmSwitch;


}
