package com.huicewang.aitesting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huicewang.aitesting.mapper.UserMapper;
import com.huicewang.aitesting.model.User;
import com.huicewang.aitesting.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichong
 * @since 2021-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
