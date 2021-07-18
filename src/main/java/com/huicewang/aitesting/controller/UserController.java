package com.huicewang.aitesting.controller;

import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/userId")
    public User getUserByUId(@RequestParam("id") int id){
        return userService.queryUserByID(id);

    }
    @GetMapping("/userAge")
    public List<User> getUserByAge(@RequestParam("age") int age){
        return userService.queryUserByAge(age);

    }
    @GetMapping("/userName")
    public List<User> getUserByName(@RequestParam("username") String username){
        return userService.queryUserByName(username);

    }
    @PostMapping("/insert")
    public int  insertUser(@RequestBody User user){
         int x= userService.insertUser(user);
         int id = user.getId();
         return id;

    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public  int updateUserByID(@RequestBody User user){
        return  userService.updateUserByID(user);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  int deleteUserByID(@RequestParam("id") int id){

        return userService.deleteUserByID(id);
    }
}
