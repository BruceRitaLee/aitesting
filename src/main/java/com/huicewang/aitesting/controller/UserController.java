package com.huicewang.aitesting.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichong
 * @since 2021-07-18
 */
@RestController
@RequestMapping("/user")
@Api
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/userId")
    @ApiOperation("根据ID获取用户信息")
    public CommonResult getUserByUId(@RequestParam("id") int id) {
        LOGGER.debug("this is a debug");
        LOGGER.warn("this is a warn");
        LOGGER.info("this is a info");
        LOGGER.error("this is a error");
        User user=userService.getById(id);
//        CommonResult result=new CommonResult(200,"c你牛逼成功了",user);
       return CommonResult.success(user);

    }

//    @GetMapping("/userName")
//    public List<User> getUserByName(@RequestParam("username") String username){
//        return userService.
//
//    }
    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public boolean  insertUser(@RequestBody User user){
        return userService.save(user);

    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation("根据用户ID更新数据")
    public  boolean updateUserByID(@RequestBody User user){
        return  userService.updateById(user);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ApiOperation("这个是删除一个用户")
    public  boolean deleteUserByID(@RequestParam("id") int id){

        return userService.removeById(id);
    }
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ApiOperation("这个是用户分页列表")
    public CommonResult listUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        Page<User> page = new Page<>(pageNum,pageSize);
        Page<User> userPage=userService.page(page);
        return CommonResult.success(CommonPage.restResult(userPage));

    }
}



