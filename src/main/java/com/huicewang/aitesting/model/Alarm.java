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
@TableName("alarm")
@ApiModel(value="Alarm对象", description="")
public class Alarm implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "任务id")
    @TableField("taskId")
    private Integer taskId;

    @ApiModelProperty(value = "项目id")
    @TableField("projectId")
    private Integer projectId;

    @ApiModelProperty(value = "报警类型")
    private String type;

    @ApiModelProperty(value = "通知人员")
    @TableField("notifyTo")
    private String notifyTo;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "报警名")
    private String name;


}
