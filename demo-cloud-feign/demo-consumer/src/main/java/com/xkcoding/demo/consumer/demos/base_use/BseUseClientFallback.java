package com.xkcoding.demo.consumer.demos.base_use;

import org.springframework.stereotype.Component;

/**
 * @author Verite
 */
@Component
public class BseUseClientFallback implements BaseUseClient {

    @Override
    public String bases() {
        return "consumer -- BseUseClientFallback123";
    }
}

