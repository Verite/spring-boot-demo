package com.xkcoding.provider.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import static com.xkcoding.provider.config.ProviderConstants.SYS_DESC;


/**
 * @author Verite
 */
@SpringBootApplication
@RestController
public class HttpProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpProviderApplication.class, args);
    }

    /**
     * 为客户端提供可调用的接口
     */
    @RequestMapping("/call/{name}")
    public String call(@PathVariable String name) {
        return LocalTime.now() + SYS_DESC + name;
    }

    /**
     * 基本使用
     */
    @RequestMapping("/base")
    public String base() {
        return LocalTime.now() + SYS_DESC + "：基本使用";
    }


}
