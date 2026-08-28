package com.demo.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceImpl {
    public String send() {
        return "Notification Send";
    }
}
