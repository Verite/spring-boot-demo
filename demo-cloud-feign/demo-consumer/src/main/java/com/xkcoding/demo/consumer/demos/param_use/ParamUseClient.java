package com.xkcoding.demo.consumer.demos.param_use;

import com.xkcoding.demo.consumer.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Verite
 */
@FeignClient(contextId = "paramUseClient", name = "spring-cloud-nacos-provider", configuration = FeignClientConfig.class)
public interface ParamUseClient {

    /**
     * 基础使用
     */
    @GetMapping(path = "/base-param")
    String param(@SpringQueryMap Params params);

}

