package com.xkcoding.demo.consumer.config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Priority;
import java.io.IOException;

/**
 * @author Verite
 */
@Configuration
@Slf4j
public class FeignClientConfig {

    // -------------------------日志开始-----------------------------

    /**
     * 日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 日志实现的类
     *
     * @return
     */
    @Bean
    public Logger feignLogger() {
        // return new Slf4jLogger();
        return new CustomFeignLogger();
    }

    private static class CustomFeignLogger extends Logger {

        @Override
        protected void log(String configKey, String format, Object... args) {
            log.info(String.format(methodTag(configKey) + format, args));
        }

        @Override
        protected void logRequest(String configKey, Level logLevel, Request request) {
            super.logRequest(configKey, logLevel, request);
        }

        @Override
        protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response,
                                                  long elapsedTime) throws IOException {
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
    }

    // -------------------------日志结束-----------------------------


    //------------------------------- 拦截器开始 -----------------------

    /**
     * 拦截器使用 添加@Priority 注解可以指定它们的执行顺序，数值越小的注解会先执行。如果没有使用@Priority注解指定执行顺序，那么Spring容器会根据Bean的加载顺序来确定执行顺序。
     * Ordered.LOWEST_PRECEDENCE
     * 如果在使用 @Order 注解时没有生效，可能是因为 @Order 注解只对实现了 Ordered 接口或者使用了 @Priority 注解的组件生效。因此，您需要确保您的拦截器类实现了 Ordered 接口或者使用了 @Priority 注解。
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Priority(2)
    static class AuthInterceptor implements RequestInterceptor {
        @Override
        public void apply(RequestTemplate template) {
            log.info("AuthInterceptor：在发送请求之前执行自定义逻辑");
        }
    }

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Priority(1)
    static class LoggingInterceptor implements RequestInterceptor {
        @Override
        public void apply(RequestTemplate template) {
            log.info("LoggingInterceptor：在发送请求之前执行自定义逻辑");
        }
    }

    //---------------------------- 拦截器结束 --------------------------


    // @Bean
    // public Request.Options options() {
    //     return new Request.Options(5000, 5000);
    // }

}
