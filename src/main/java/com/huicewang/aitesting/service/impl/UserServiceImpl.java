package com.huicewang.aitesting.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huicewang.aitesting.mapper.UserMapper;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichong
 * 在这增加点东西，我提交后回滚，查看有没有效果啊
 * @since 2021-07-18
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public SaTokenInfo login(String username,String password){
        SaTokenInfo saTokenInfo=null;
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = this.getOne(queryWrapper);
        if(user==null){
            return  null;
        }
        if(!SaSecureUtil.md5(password).equals(user.getPassword())){
            return  null;
        }
        StpUtil.login(user.getId());
        saTokenInfo = StpUtil.getTokenInfo();

        return saTokenInfo;
    }

    @Override
    public SaTokenInfo registerUser(String username, String password) {

        return null;
    }

}
