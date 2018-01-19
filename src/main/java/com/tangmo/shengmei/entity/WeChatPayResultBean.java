package com.tangmo.shengmei.entity;

public class WeChatPayResultBean {
	
	private String partnerId;
	private String prepayId;
	private String nonceStr;
	private Long timeStamp;
	private String package2;
	private String sign;
	
	
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	

	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getPackage2() {
		return package2;
	}
	public void setPackage2(String package2) {
		this.package2 = package2;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "WeChatPayResult [partnerId=" + partnerId + ", prepayId=" + prepayId + ", nonceStr=" + nonceStr
				+ ", timeStamp=" + timeStamp + ", package2=" + package2 + ", sign=" + sign + "]";
	}
	
	
	

}
