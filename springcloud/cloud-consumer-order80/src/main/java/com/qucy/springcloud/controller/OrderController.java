package com.qucy.springcloud.controller;

import com.qucy.springcloud.entities.CommonResult;
import com.qucy.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    public static final String PAYMENTSRV_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(Payment payment)
    {
        return restTemplate.postForObject(PAYMENTSRV_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult getPayment(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENTSRV_URL + "/payment/get/"+ id,CommonResult.class);
    }
}
