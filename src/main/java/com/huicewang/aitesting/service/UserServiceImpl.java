package com.huicewang.aitesting.service;

import com.huicewang.aitesting.dao.UserDao;
import com.huicewang.aitesting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByID(int id) {
        return userDao.getUserByID(id);
    }

    @Override
    public List<User> queryUserByAge(int age) {
        return userDao.getUserByAge(age);
    }

    @Override
    public List<User> queryUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUserByID(User user) { return userDao.updateUserByID(user);
    }

    @Override
    public int deleteUserByID(int id) {
        return userDao.deleteUserByID(id);
    }
}
