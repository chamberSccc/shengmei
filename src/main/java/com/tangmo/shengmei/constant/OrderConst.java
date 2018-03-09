package com.tangmo.shengmei.constant;

/**
 * @author Chamber
 * @date 2018/3/8.
 */
public class OrderConst {

    /**
     * 等待支付
     */
    public static final Byte NEW_ORDER = 0;
    /**
     * 交易完成
     */
    public static final Byte DEAL_DONE = 1;

    /**
     * 待发货
     */
    public static final Byte WAIT_DELIVER = 2;

    /**
     * 已发货
     */
    public static final Byte DONE_DELIVER = 3;

    /**
     * 已收货
     */
    public static final Byte RECEIVE__DELIVER = 4;

    /**
     * 评价完成
     */
    public static final Byte COMMENT_DONE = 5;

    /**
     * 交易关闭
     */
    public static final Byte DEAL_COLSE = 4;

}
