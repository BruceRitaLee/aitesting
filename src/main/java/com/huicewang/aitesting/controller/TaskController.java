package com.huicewang.aitesting.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.ApiCase;
import com.huicewang.aitesting.model.Task;
import com.huicewang.aitesting.service.TaskService;
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
@RequestMapping("/task")
@Api
public class TaskController {
    private static  final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("根据ID获取到项目信息")
    public CommonResult getTaskById(@RequestParam("id") int id){
        return CommonResult.success(taskService.getById(id));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation("插入新的Task")
    public  CommonResult insertTask(@RequestBody Task task){
        boolean flag = taskService.save(task);
        if(flag){
            return  CommonResult.success(task);
        }else{
            return  CommonResult.failed();
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据ID修改Task")
    public CommonResult updateTaskById(@RequestBody Task task){
        boolean flag = taskService.updateById(task);
        if(flag){
            return  CommonResult.success(task);
        }else{
            return  CommonResult.failed();
        }
    }
    @ApiOperation("根据ID删除Task")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult deleteTaskById(@RequestParam("id") int id ){
        boolean flag = taskService.removeById(id);
        if(flag){
            return  CommonResult.success();
        }else{
            return  CommonResult.failed();
        }
    }
    @RequestMapping(value = "tasklist",method = RequestMethod.GET)
    @ApiOperation("这个是任务分页列表")
    public CommonResult listTask(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        Page<Task> page = new Page<>(pageNum,pageSize);
        Page<Task> taskPage=taskService.page(page);
        return CommonResult.success(CommonPage.restResult(taskPage));

    }


}



