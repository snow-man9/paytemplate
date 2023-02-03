package com.example.paytemplate.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.junit.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author:hc
 * @Date:2023/2/3 15:32
 */
@Component
public class BestPayConfig {

    @Bean
    public BestPayService bestPayService() {

        WxPayConfig wxPayConfig = new WxPayConfig();
        //公众号appid
        wxPayConfig.setAppId("wx3e6b9f1c5a7ff034");
        //商户id
        wxPayConfig.setMchId("1614433647");
        //商户密钥
        wxPayConfig.setMchKey("Aa111111111122222222223333333333");

        wxPayConfig.setNotifyUrl("http://127.0.0.1:8080/pay/notify");


        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        return bestPayService;
    }
}
