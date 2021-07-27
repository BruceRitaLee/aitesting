package com.huicewang.aitesting.service.impl;

import com.huicewang.aitesting.model.Task;
import com.huicewang.aitesting.mapper.TaskMapper;
import com.huicewang.aitesting.service.TaskService;
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
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
