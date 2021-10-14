package com.huicewang.aitesting.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class SignUtil {

    /**
     * @param params HashMap
     * @spliter params spliter 分隔符
     * @return String
     * @throws @Description: 对所有参数进行拼接
     * @Title:signString
     */
    public static String signStringAllParams(Map<String, Object> params, String spliter) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder("");
        for (String paramKey : keys) {
            String value = params.get(paramKey) + "";

            if (StringUtils.isNotBlank(value)) {
                prestr.append(paramKey).append('=').append(value);
                if (!StringUtils.isEmpty(spliter)) {
                    prestr.append(spliter);
                }
            }
        }
        if (!StringUtils.isEmpty(spliter) && prestr.length() > 0 && prestr.toString()
                .endsWith(spliter)) {
            return prestr.substring(0, prestr.length() - 1);
        }
        return prestr.toString();
    }


    /**
     * @return boolean
     * @throws @Description: 验证String是否长度为空，或者为null
     * @Title:stringIsEmpty
     */
    private static boolean stringIsEmpty(String query) {
        boolean ret = false;
        if (query == null || "".equals(query.trim())) {
            ret = true;
        }
        return ret;
    }

    /**
     * @return boolean
     * @throws @Description: string的char是否都是0-9之间的
     * @Title:charsIs0To9
     */
    private static boolean charsIs0To9(String chars) {
        return chars.matches("[0-9]+");
    }



}
