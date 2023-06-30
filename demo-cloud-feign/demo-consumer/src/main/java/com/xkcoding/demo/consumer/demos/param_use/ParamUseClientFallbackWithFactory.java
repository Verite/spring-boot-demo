package com.xkcoding.demo.consumer.demos.param_use;

import com.xkcoding.demo.consumer.demos.base_use.BaseUseClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author Verite
 */
@Slf4j
public class ParamUseClientFallbackWithFactory implements FallbackFactory<BaseUseClient> {

    @Override
    public BaseUseClient create(Throwable cause) {
        log.info("consumer--BaseUseClientFallbackWithFactory : " + cause.getMessage());
        return () -> "consumer--BaseUseClientFallbackWithFactory : " + cause.getMessage();
    }
}

