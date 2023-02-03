package com.example.paytemplate.service.impl;

import com.example.paytemplate.PaytemplateApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author:hc
 * @Date:2023/2/2 20:40
 */

public class PayServiceImplTest extends PaytemplateApplicationTests {

    @Autowired
    private PayServiceImpl payService;

    @Test
    public void create() {
        payService.create("123123123321", BigDecimal.valueOf(0.01));
    }
}