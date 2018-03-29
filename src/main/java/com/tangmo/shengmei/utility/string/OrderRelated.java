package com.tangmo.shengmei.utility.string;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author boge
 * @date 18/3/8
 * @description
 */

public class OrderRelated {

    private static long orderNum = 0l;
    private static String date;

    /**
     * 生成商城订单编号
     *
     * @return
     */
    public static synchronized String getOrderNo(Integer number) {
        Random random = new Random();
        Integer x = random.nextInt(number * 10000);
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if (date == null || !date.equals(str)) {
            date = str;
            orderNum = 0l;
        }
        orderNum++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;
        return orderNo + x.toString() + "00";
    }

    /**
     * 生成商城订单编号
     *
     * @return
     */
    public static synchronized String getIllegalOrderNo(Integer number) {
        Random random = new Random();
        Integer x = random.nextInt(number * 21001);
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if (date == null || !date.equals(str)) {
            date = str;
            orderNum = 0l;
        }
        orderNum++;
        long orderNo = Long.parseLong((date)) * 21001;
        orderNo += orderNum;
        return orderNo + x.toString() + "01";
    }
}
