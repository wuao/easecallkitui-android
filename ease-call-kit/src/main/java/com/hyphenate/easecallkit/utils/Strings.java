package com.hyphenate.easecallkit.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;



public class Strings {
    public static final String EMPTY = "";
    public static final String ZERO = "0";

    public static int compares(String str1, String str2) {
        int handled;
        if (str1 == str2) {
            handled = 0;
        } else if (str1 == null && str2 != null) {
            handled = -1;
        } else if (str1 != null && str2 == null) {
            handled = 1;
        } else {
            handled = str1.compareTo(str2);
        }
        return handled;
    }


    public static boolean equals(CharSequence str1, CharSequence str2) {
        boolean handled = false;
        if (str1 == str2) {
            handled = true;
        } else if (str1 != null) {
            handled = str1.equals(str2);
        }
        return handled;
    }

    public static boolean notEquals(CharSequence str1, CharSequence str2) {
        return !equals(str1, str2);
    }


    public static String decode(String url) {
        try {
            return URLDecoder.decode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }


    public static boolean containsIgnoreCase(String str1, String str2) {
        return str1.toLowerCase().contains(str2.toLowerCase());
    }

    public static boolean contains(String str1, String str2) {
        return str1.contains(str2);
    }

    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }


    //获取小数点位数
    public static int getTextDecLength(String text) {
        String[] value = text.split("\\.");
        if (value.length == 2) {
            return value[1].length();
        }
        return 0;
    }


    /**
     * 判断double是否是整数
     *
     * @param obj
     * @return
     */
    public static boolean isIntegerForDouble(double obj) {
        double eps = 1e-10;  // 精度范围
        return obj - Math.floor(obj) < eps;
    }

    /**
     * 判断是否为空或null 输入参数
     *
     * @param target
     * @return
     */
    public static boolean checkNull(Object target) {
        if (target == null || "".equals(target.toString().trim()) || "null".equalsIgnoreCase(target.toString().trim())) {
            return true;
        }
        return false;
    }
}
