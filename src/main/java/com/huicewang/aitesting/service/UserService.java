package com.huicewang.aitesting.service;

import com.huicewang.aitesting.model.User;

import java.util.List;

public interface UserService {
    public User queryUserByID(int id);
    public List<User> queryUserByAge(int age);
    public List<User> queryUserByName(String username);
    public int insertUser(User user);
    public int updateUserByID(User user);
    public int deleteUserByID(int id);



}