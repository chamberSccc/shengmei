package com.tangmo.shengmei.utility.string;

/**
 * @author boge
 * @date 18/3/30
 * @description
 */

public class StringUtil {

    public static String converToString(String[] ig) {
        String str = "";
        if (ig != null && ig.length > 0) {
            for (int i = 0; i < ig.length; i++) {
                str += ig[i] + ",";
            }
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }
}
