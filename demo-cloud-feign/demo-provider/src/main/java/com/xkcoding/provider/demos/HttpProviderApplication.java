package com.xkcoding.provider.demos;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xkcoding.provider.config.Params;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import static com.xkcoding.provider.config.ProviderConstants.SYS_DESC;


/**
 * @author Verite
 */
@RestController
public class HttpProviderApplication {

    /**
     * 基本使用
     */
    @RequestMapping("/base")
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    })
    public String base() throws InterruptedException {
        Thread.sleep(2000);
        return LocalTime.now() + SYS_DESC + "：基本使用";
    }

    @RequestMapping("/base-param")
    public String param(Params params) throws InterruptedException {
        Thread.sleep(2000);
        return LocalTime.now() + SYS_DESC + "：pojo 基本使用 ;param:" + params;
    }

    public String fallback() {
        return "fallback -- provider";
    }
}
