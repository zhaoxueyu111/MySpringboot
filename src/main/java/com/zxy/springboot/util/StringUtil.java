package com.zxy.springboot.util;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (null == str || str.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
