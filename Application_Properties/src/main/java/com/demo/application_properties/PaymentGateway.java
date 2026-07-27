package com.demo.application_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

//    @Value("${payment-gateway.type}")
//    private String type;
//
//    @Value("${payment-gateway.retrycount}")
//    private int retrycount;

//    public PaymentGateway(@Value("${PaymentGateway.type}") String type,
//                          @Value("${PaymentGateway.retryCount}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

    private PaymentProperties properties;

    public PaymentGateway( PaymentProperties paymentProperties){
        this.properties = properties;
    }

    public String getType() {
        return properties.getType();
    }

    public int getRetryCount(){
        return properties.getRetrycount();
    }

    public boolean getIsEnabled(){
        return properties.isEnabled();
    }

    public int getTimeout(){
        return properties.getTimeout();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getIsEnabled());
        System.out.println(getTimeout());
    }
}