package com.demo.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyNotificationServiceImpl implements NotificationService {
    @Override
    public String send() {
        return "Dummy Notification Send";
    }
}
