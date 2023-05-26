package com.xkcoding.demo.consumer.demos;

import com.xkcoding.demo.consumer.config.FeignClientConfig;
import com.xkcoding.demo.consumer.demos.manual_use.InterceptorUseClient;
import com.xkcoding.demo.consumer.demos.manual_use.LoggingUseClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FeignUseClientBaseTest {

    private FeignClientConfig feignClientConfigUnderTest;


    @Before
    public void setUp() {
        feignClientConfigUnderTest = new FeignClientConfig();
    }

    @Test
    public void testInterceptorUseClient() {
        // Setup
        // Run the test
        final InterceptorUseClient interceptorUseClient = feignClientConfigUnderTest.interceptorUseClient();
        String base = interceptorUseClient.base();
        Assert.assertTrue(base.contains("服务提供者"));
        // Verify the results
    }

    @Test
    public void testManualUseClient() {
        // Setup
        // Run the test
        final LoggingUseClient loggingUseClient = feignClientConfigUnderTest.loggingUseClient();
        String base = loggingUseClient.base();
        Assert.assertTrue(base.contains("服务提供者"));
        // Verify the results
    }
}
