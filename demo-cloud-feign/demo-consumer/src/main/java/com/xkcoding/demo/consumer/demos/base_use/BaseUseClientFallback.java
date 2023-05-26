package com.xkcoding.demo.consumer.demos.base_use;


import org.springframework.stereotype.Component;

/**
 * @author Verite
 */
@Component
public class BaseUseClientFallback implements BaseUseClient {

    @Override
    public String base() {
        return "fallback -- consumer";
    }
}

