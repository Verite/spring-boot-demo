package com.xkcoding.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Verite
 */
@SpringBootApplication
@EnableHystrix
public class SpringBootDemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoProviderApplication.class, args);
    }

}
