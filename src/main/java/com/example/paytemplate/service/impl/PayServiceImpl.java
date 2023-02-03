package com.example.paytemplate.service.impl;

import com.example.paytemplate.service.IPayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author:hc
 * @Date:2023/2/2 19:48
 */
@Slf4j
@Service
public class PayServiceImpl implements IPayService {

    @Autowired
    private BestPayService bestPayService;

    @Override
    public PayResponse create(String userId, BigDecimal amount) {


        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("4559066-最好的支付SDK");
        payRequest.setOrderId(userId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);

        PayResponse response = bestPayService.pay(payRequest);

        log.info("response={}", response);
        return response;
    }

    @Override
    public String asyncNotify(String notifyData) {
        PayResponse response = bestPayService.asyncNotify(notifyData);
        log.info("notifyData={}", response);



        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }
}
