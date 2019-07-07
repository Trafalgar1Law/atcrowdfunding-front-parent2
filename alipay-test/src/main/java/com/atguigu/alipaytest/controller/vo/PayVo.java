package com.atguigu.alipaytest.controller.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PayVo {
    private String out_trade_no;

    private String subject;

    private String total_amount;

    private String body;


}
