package com.huicewang.aitesting.service.impl;

import com.huicewang.aitesting.model.Api;
import com.huicewang.aitesting.mapper.ApiMapper;
import com.huicewang.aitesting.service.ApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichong
 * @since 2021-07-25
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

}
