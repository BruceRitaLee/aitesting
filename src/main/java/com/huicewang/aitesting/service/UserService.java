package com.huicewang.aitesting.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huicewang.aitesting.model.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huice
 * @since 2021-07-18
 */
public interface UserService extends IService<User> {
    SaTokenInfo login(String username, String password);

    SaTokenInfo registerUser(String username, String password);
}