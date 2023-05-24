package com.xkcoding.demo.consumer.demos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Verite
 */
// nacos 服务 id
@FeignClient("spring-cloud-nacos-provider")
public interface SpringCloudNacosProviderClient {
    /**
     * 使用 get 方式，调用服务提供者的 /call/{name} 接口
     *
     * @param name 姓名
     * @return string
     */
    @GetMapping("/call/{name}")
    String call(@PathVariable(value = "name") String name);

    /**
     * 基础使用
     *
     * @return
     */
    @GetMapping("/base")
    String base();
}
