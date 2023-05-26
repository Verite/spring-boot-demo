package com.xkcoding.demo.consumer.demos.manual_use;

import feign.RequestLine;

/**
 * @author Verite
 */
public interface LoggingUseClient {

    /**
     * 基础使用
     */
    @RequestLine("GET /base")
    String base();

}
