package com.tangmo.shengmei.utility.number;

/**
 * @author Chamber
 * @date 2018/1/17.
 */
public class RandomString {

    /**
     * 生成六位随机数
     *
     * @return
     */
    public static String sixRandomNumber() {
        int number = (int) ((Math.random() * 9 + 1) * 100000);
        String result = String.valueOf(number);
        return result;
    }
}
