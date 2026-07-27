package com.demo.application_properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationPropertiesApplication {

    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(ApplicationPropertiesApplication.class, args);

       PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

//       paymentGateway.setType("Paytm");
//       paymentGateway.setRetryCount(5);

//        System.out.println(paymentGateway.getType());
//        System.out.println(paymentGateway.getRetryCount());

     paymentGateway.print();

    }

}
