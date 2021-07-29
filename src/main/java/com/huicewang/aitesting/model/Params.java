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
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("params")
@ApiModel(value="Params对象", description="")
public class Params implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "参数id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目id")
    @TableField("projectId")
    private Integer projectId;

    @ApiModelProperty(value = "分组id")
    @TableField("apiGroupId")
    private Integer apiGroupId;

    @ApiModelProperty(value = "用例id")
    @TableField("caseId")
    private Integer caseId;

    @ApiModelProperty(value = "参数名")
    private String name;

    @ApiModelProperty(value = "参数值")
    private String value;

    @ApiModelProperty(value = "是否全局(1：全局，0非全局)")
    private Integer global;

    @ApiModelProperty(value = "参数类型(content :常量，casse：依赖用例)")
    private String type;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "添加人")
    private String author;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;


}
