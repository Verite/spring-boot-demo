package com.xkcoding.demo.consumer.demos.base_use;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Verite
 */
@Component
public class BaseUseClientFallbackWithFactory implements FallbackFactory<BaseUseClient> {

    @Override
    public BaseUseClient create(Throwable cause) {
        return () -> "fallback -- consumer: " + cause.getMessage();
    }
}

