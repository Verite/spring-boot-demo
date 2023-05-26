package com.xkcoding.demo.consumer.demos.param_use;

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
@RequestMapping("/param-use")
public class ParamUseController {

    /**
     * 加载 openfeign client
     */
    @Resource
    private ParamUseClient paramUseClient;

    @GetMapping()
    public String param(Params params) {
        return paramUseClient.param(params);
    }

}
