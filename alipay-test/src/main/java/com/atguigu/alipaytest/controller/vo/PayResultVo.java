package com.atguigu.alipaytest.controller.vo;

import lombok.Data;

@Data
public class PayResultVo {

    private String out_trade_no;//订单号

    private String total_amount;

    //支付交易流水
    private String trade_no;




}
