package com.huicewang.aitesting.controller;


import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.Project;
import com.huicewang.aitesting.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichong
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/project")
@Api
public class ProjectController {
    private static  final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到项目信息")
    public CommonResult getProjectById(@RequestParam("id") int id){
        return CommonResult.success(projectService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的Project")
    public  CommonResult insertProject(@RequestBody Project project){
        boolean flag = projectService.save(project);
        if(flag){
            return  CommonResult.success(project);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改Project")
    public CommonResult updateProjectById(@RequestBody Project project){
        boolean flag = projectService.updateById(project);
        if(flag){
            return  CommonResult.success(project);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Project")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteProjectById(@RequestParam("id") int id ){
        boolean flag = projectService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }


}

