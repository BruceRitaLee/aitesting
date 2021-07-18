package com.huicewang.aitesting.dao;

import com.huicewang.aitesting.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface UserDao {

   public User getUserByID(@Param("id") int id);
    public List<User> getUserByAge(@Param("age") int age);
    public List<User> getUserByName(@Param("username") String username);
    public int insertUser(@RequestBody User user);
    public int updateUserByID(@RequestBody User user);
    public int deleteUserByID(@Param("id") int id);



}

