package com.xkcoding.demo.consumer.demos.base_use;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Verite
 */
// nacos 服务 id
@FeignClient(value = "spring-cloud-nacos-provider"
    ,
    fallback = BseUseClientFallback.class
    // configuration = FeignClientConfig.class
)
public interface BaseUseClient {

    /**
     * 基础使用
     */
    @GetMapping("/base")
    String bases();
}
