package com.xuanyu.utils;

import org.apache.commons.lang.StringUtils;

public class UtilsPath {

    /**
     * 获取到classes目录
     * @return path
     */
    public static String getClassPath(){
        String systemName = System.getProperty("os.name");

        //判断当前环境，如果是Windows 要截取路径的第一个 '/'
        if(!StringUtils.isBlank(systemName) && systemName.indexOf("Windows") !=-1){
            return UtilsPath.class.getResource("/").getFile().toString().substring(1);
        }else{
            return UtilsPath.class.getResource("/").getFile().toString();
        }
    }

    /**
     * 获取 root目录
     * @return path
     */
    public static String getRootPath(){
        return getWEB_INF().replace("WEB-INF/", "");
    }
    /**
     * 获取 web-inf目录
     * @return path
     */
    public static String getWEB_INF(){
        return getClassPath().replace("classes/", "");
    }
}
