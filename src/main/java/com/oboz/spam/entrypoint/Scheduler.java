package com.oboz.spam.entrypoint;

import com.oboz.spam.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {
    @Autowired
    SendService sendService;

    @Scheduled(cron = "${cron.expression}")
    public void run() {
        try {
            sendService.sendTo("123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
