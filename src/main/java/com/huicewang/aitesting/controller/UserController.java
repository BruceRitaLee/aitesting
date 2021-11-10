package com.huicewang.aitesting.controller;


import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huicewang.aitesting.common.CommonPage;
import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.common.util.RedisUtil;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@CrossOrigin
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    RedisUtil redisUtil;

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
    public CommonResult  insertUser(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String username = user.getUsername();
        queryWrapper.eq("username",username);
        if(userService.getOne(queryWrapper)!=null){
            return CommonResult.failed("该用户已注册");
        }
        String password = SaSecureUtil.md5(user.getPassword());
        user.setPassword(password);
        boolean flag = userService.save(user);
        if(redisUtil.hasKey("hah")){
            redisUtil.del("hah");
        }
        if(flag){

            return CommonResult.success("注册成功");
        }else {
           return CommonResult.failed("注册失败");
        }


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
        Page<User> userPage;
        //查看缓存中是否存在值，如果存在直接取缓存中数据，没有的话从数据库取值，并添加到缓存中
        if(redisUtil.hasKey("hah")){
            userPage= (Page<User>) redisUtil.get("hah");
            LOGGER.info("我是缓存");

        }else {
            Page<User> page = new Page<>(pageNum, pageSize);
             userPage = userService.page(page);
             redisUtil.set("hah",userPage,600);
             LOGGER.info("我写入缓存了");

        }
        return CommonResult.success(CommonPage.restResult(userPage));



    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ApiOperation("登录账号，传给前端token信息")
    public CommonResult getLogin(@RequestBody User user){
        SaTokenInfo saTokenInfo = userService.login(user.getUsername(),user.getPassword());
        if(saTokenInfo==null){
            LOGGER.debug("login Failed",user.getUsername());
            return  CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",saTokenInfo.getTokenValue());
        tokenMap.put("tokenHead",saTokenInfo.getTokenName());
        return CommonResult.success(tokenMap);
    }
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    @ApiOperation("退出登录，后端清空token信息")
    public CommonResult getLogout(@NotNull @RequestParam String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userService.getOne(queryWrapper);
        if(user==null){
            return  CommonResult.failed("用户不存在");
        }
        StpUtil.logoutByLoginId(user.getId());

        return CommonResult.success("退出成功");
    }
}



