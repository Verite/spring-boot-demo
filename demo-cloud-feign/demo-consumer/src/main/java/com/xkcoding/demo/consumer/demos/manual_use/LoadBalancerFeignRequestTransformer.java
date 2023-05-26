package com.xkcoding.demo.consumer.demos.manual_use;

import feign.Request;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @author Verite
 */
public interface LoadBalancerFeignRequestTransformer {

    Request transformRequest(Request request, ServiceInstance instance);

}
