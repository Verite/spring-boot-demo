package com.xkcoding.demo.consumer.demos.base_use;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用 FeignClientsConfiguration
 *
 * @author Verite
 */
@RestController()
@RequestMapping("/base-use")
public class BaseUseController {

    /**
     * 加载 openfeign client
     */
    @Resource
    private BaseUseClient baseUseClient;

    @GetMapping()
    public String base() {
        return baseUseClient.bases();
    }

}
