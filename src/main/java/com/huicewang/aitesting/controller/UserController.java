package com.huicewang.aitesting.controller;


import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userId")
    public CommonResult getUserByUId(@RequestParam("id") int id) {

        User user=userService.getById(id);
//        CommonResult result=new CommonResult(200,"c你牛逼成功了",user);
       return CommonResult.success(user);

    }

//    @GetMapping("/userName")
//    public List<User> getUserByName(@RequestParam("username") String username){
//        return userService.
//
//    }
    @PostMapping("/insert")
    public boolean  insertUser(@RequestBody User user){
        return userService.save(user);

    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public  boolean updateUserByID(@RequestBody User user){
        return  userService.updateById(user);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  boolean deleteUserByID(@RequestParam("id") int id){

        return userService.removeById(id);
    }
}



