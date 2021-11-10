package com.huicewang.aitesting.validator;


import cn.dev33.satoken.secure.SaSecureUtil;
import org.apache.commons.lang3.StringUtils;


public class demo {
    public static String getSign(String key, String cid, String param, String uid, String ver, String t) {

        StringBuilder strBuilder = new StringBuilder("cid=");
        strBuilder.append(cid);
        if (StringUtils.isNotEmpty(param)) {
            strBuilder.append(";param=").append(param);
        }
        if (StringUtils.isNotEmpty(uid)) {
            strBuilder.append(";uid=").append(uid);
        }
        if (StringUtils.isNotEmpty(ver)) {
            strBuilder.append(";ver=").append(ver);
        }
        if (StringUtils.isNotEmpty(t)) {
            strBuilder.append(";t=").append(t);
        }
        strBuilder.append(";" + key);
        String str = strBuilder.toString();
        //md5加密
        String sign = SaSecureUtil.md5(str);
        return sign;
    }

    public static void main(String[] args) {
        String cid="508";
        String key = "10E8693282A14616386DEFFEC7C8A578";
        String t = "1635836731";
        String ver = "10.62";
        String param = "{'carType':'0'}";
        String sign = getSign(key,cid,param,null,ver,t);
        System.out.println(sign);



    }
}
