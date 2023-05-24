package com.xkcoding.demo.consumer.demos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Verite
 */
@RestController
public class ConsumerController {
    /**
     * 加载 openfeign client
     */
    @Resource
    private SpringCloudNacosProviderClient providerClient;

    @GetMapping("/consumer")
    public String consumer(@RequestParam String name) {
        return providerClient.call(name);
    }

    @GetMapping("/base")
    public String base() {
        return providerClient.base();
    }

}
