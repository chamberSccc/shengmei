package com.tangmo.shengmei.entity;

import lombok.Data;

@Data
public class WeChatPayResultBean {
	
	private String partnerId;
	private String prepayId;
	private Integer userId;
	private String nonceStr;
	private Long timeStamp;
	private String package2;
	private String sign;
	private String out_trade_no;
	private int total_fee;
	private String trade_type;

	@Override
	public String toString() {
		return "WeChatPayResult [partnerId=" + partnerId + ", prepayId=" + prepayId + ", nonceStr=" + nonceStr
				+ ", timeStamp=" + timeStamp + ", package2=" + package2 + ", sign=" + sign + "]";
	}
	
	
	

}
