package com.huicewang.aitesting.service.impl;


import com.huicewang.aitesting.service.ParameterSettingService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: aitesting
 * @author: huice
 * @create: 2021-09-10 19:14
 **/
@Service
public class ParameterSettingServiceImpl implements ParameterSettingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterSettingServiceImpl.class);

    /**
     * 参数替换
     * @parameters 参数
     * @return 返回
     */
    public  String evalParameter(String parameters, Map<String, Object> mapValues) {
        if(StringUtils.isBlank(parameters)){
            return parameters;
        }
        for(String key : mapValues.keySet()){
            Pattern pattern = Pattern.compile("\\$\\{" + key + "\\}");
            Matcher matcher = pattern.matcher(parameters);
            while (matcher.find()) {
                String group = matcher.group(0);
                parameters = parameters.replace(group, mapValues.get(key).toString());
            }
        }
        return parameters;
    }


}
