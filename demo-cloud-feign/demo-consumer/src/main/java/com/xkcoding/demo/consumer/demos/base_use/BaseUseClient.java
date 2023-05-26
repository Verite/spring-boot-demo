package com.xkcoding.demo.consumer.demos.base_use;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Verite
 */
// nacos 服务 id
@FeignClient(contextId = "baseUseProviderClient",name = "spring-cloud-nacos-provider",
    // fallbackFactory = BaseUseProviderClientFallbackWithFactory.class,
    fallback = BaseUseClientFallback.class
)
public interface BaseUseClient {

    /**
     * 基础使用
     */
    @GetMapping("/base")
    // @CacheRemove(cacheName = "base")
    String base();
}
