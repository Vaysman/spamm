package com.oboz.spam;

import com.oboz.spam.entrypoint.SpamProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(SpamProperties.class)
public class SpamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpamApplication.class, args);
    }
}
