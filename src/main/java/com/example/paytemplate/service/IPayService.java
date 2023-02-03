package com.example.paytemplate.service;

import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

/**
 * @Author:hc
 * @Date:2023/2/2 19:40
 */
public interface IPayService {
    /**
     * 创建/发起支付
     */
    PayResponse create(String userId, BigDecimal amount);

    String asyncNotify(String notifyData);
}
