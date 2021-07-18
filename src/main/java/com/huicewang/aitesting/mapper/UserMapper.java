package com.huicewang.aitesting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huicewang.aitesting.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huice
 * @since 2021-07-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
