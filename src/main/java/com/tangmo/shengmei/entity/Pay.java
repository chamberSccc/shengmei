package com.tangmo.shengmei.entity;

import lombok.Data;

@Data
public class Pay {
	
	private String appid;//公众号ID
	private String mch_id;//商户号
	private String nonce_str;//随机字符串
	private String sign;//签名
	private String body;//商品描述
	private String out_trade_no;//订单号
	private int total_fee;//总金额
	private String spbill_create_ip;//终端IP
	private String notify_url;//通知地址
	private String trade_type;//交易类型
	private String openid; //支付用户唯一open_id;
	private String device_info;
	private String out_refund_no;//商户退款单号;
	private String return_msg;
	private String result_code;
	private Integer userId;
	private String payTarget;

	public Pay() {
	}

	public Pay(String appid, String mch_id, String nonce_str, String sign, String body) {
		this.appid = appid;
		this.mch_id = mch_id;
		this.nonce_str = nonce_str;
		this.sign = sign;
		this.body = body;
	}

	public Pay(WeChatPayResultBean weChatPayResultBean){
		this.out_trade_no = weChatPayResultBean.getOut_trade_no();
		this.userId = weChatPayResultBean.getUserId();
		this.trade_type = weChatPayResultBean.getTrade_type();
		this.total_fee = weChatPayResultBean.getTotal_fee();
	}

	@Override
	public String toString() {
		return "Pay [appid=" + appid + ", mch_id=" + mch_id + ", nonce_str="
				+ nonce_str + ", sign=" + sign + ", body=" + body
				+ ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee
				+ ", spbill_create_ip=" + spbill_create_ip + ", notify_url="
				+ notify_url + ", trade_type=" + trade_type + ", openid="
				+ openid + ", device_info=" + device_info + "]";
	}

}
