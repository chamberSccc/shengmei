package com.tangmo.shengmei.entity;

import lombok.Data;


/**
 * @author boge
 * @date 18/1/19
 * @description
 */
@Data
public class IllegalDetail {

    private String canHandle;
    private String address;
    private String handleFee;
    private String content;
    private String score;
    private String price;
    private String time;

    public IllegalDetail() {
    }

    public IllegalDetail(String canHandle, String address, String handleFee,
                         String content, String score, String price, String time) {
        this.canHandle = canHandle;
        this.address = address;
        this.handleFee = handleFee;
        this.content = content;
        this.score = score;
        this.price = price;
        this.time = time;
    }
}
