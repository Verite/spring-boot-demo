package com.xkcoding.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Verite
 */
@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class SpringBootDemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoConsumerApplication.class, args);
    }

}
