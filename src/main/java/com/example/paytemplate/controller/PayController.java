package com.example.paytemplate.controller;

import com.example.paytemplate.service.IPayService;
import com.example.paytemplate.service.impl.PayServiceImpl;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:hc
 * @Date:2023/2/2 21:12
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private PayServiceImpl payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId" ) String orderId,
                               @RequestParam("amount") BigDecimal amount) {

        PayResponse response = payService.create(orderId, BigDecimal.valueOf(0.01));

        Map map = new HashMap<>();
        map.put("codeUrl", response.getCodeUrl());
        return new ModelAndView("create", map);
    }

    @PostMapping("/notify")
    public String asyncNotify(@RequestBody String notifyData) {
        return payService.asyncNotify(notifyData);
    }

}
