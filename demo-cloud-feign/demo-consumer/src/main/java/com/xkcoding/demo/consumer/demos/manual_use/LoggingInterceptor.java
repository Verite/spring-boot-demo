package com.xkcoding.demo.consumer.demos.manual_use;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * 拦截器的使用
 *
 * @author Verite
 */
@Slf4j
public class LoggingInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("LoggingInterceptor：在发送请求之前执行自定义逻辑");
        log.info("LoggingInterceptor Feign request...");
        log.info("LoggingInterceptor Request URL: " + template.url());
        log.info("LoggingInterceptor 可以在这里记录日志或执行其他操作");
    }
}
