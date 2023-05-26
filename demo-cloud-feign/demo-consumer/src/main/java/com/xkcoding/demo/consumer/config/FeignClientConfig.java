package com.xkcoding.demo.consumer.config;

import com.xkcoding.demo.consumer.demos.manual_use.InterceptorUseClient;
import com.xkcoding.demo.consumer.demos.manual_use.LoadBalancerFeignRequestTransformer;
import com.xkcoding.demo.consumer.demos.manual_use.LoggingInterceptor;
import com.xkcoding.demo.consumer.demos.manual_use.LoggingUseClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Verite
 */
@Configuration
@Slf4j
public class FeignClientConfig {
    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Logger feignLogger() {
        return new Slf4jLogger();
    }

    @Bean
    public LoadBalancerFeignRequestTransformer transformer() {
        return (request, instance) -> {
            log.info("instance start");
            log.info(instance.getInstanceId());
            log.info(instance.getHost());
            log.info(String.valueOf(instance.getPort()));
            log.info("instance end");
            Map<String, Collection<String>> headers = new HashMap<>(request.headers());
            headers.put("X-ServiceId", Collections.singletonList(instance.getServiceId()));
            headers.put("X-InstanceId", Collections.singletonList(instance.getInstanceId()));
            return Request.create(request.httpMethod(), request.url(), headers, request.body(), request.charset(),
                request.requestTemplate());
        };
    }


    /**
     * 日志的使用
     *
     * @return
     */
    @Bean
    public LoggingUseClient loggingUseClient() {
        return Feign.builder()
            // 日志记录
            .logger(feignLogger())
            .logLevel(feignLoggerLevel())
            .target(LoggingUseClient.class, "http://localhost:20001");
    }

    /**
     * 添加拦截器
     *
     * @return
     */
    @Bean
    public InterceptorUseClient interceptorUseClient() {
        return Feign.builder()
            .requestInterceptor(loggingInterceptor())
            .target(InterceptorUseClient.class, "http://localhost:20001");
    }
}
