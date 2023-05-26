package com.xkcoding.demo.consumer.demos.base_use;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(BaseUseController.class)
public class BaseUseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BaseUseClient mockProviderClient;

    @MockBean
    private BaseUseClientFallbackWithFactory mockBaseUseProviderClientFallbackFactory;

    @Test
    public void testBase() throws Exception {
        // Setup
        when(mockProviderClient.base()).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/base-use")
                .accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

        // Verify the results
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("result", response.getContentAsString());
    }

    @Test
    public void testBaseFallback() throws Exception {
        // Setup
        when(mockProviderClient.base()).thenThrow(new RuntimeException("fallback"));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/base-use")
                .accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

        // Verify the results
        assertEquals("fallback", response.getContentAsString());
    }

    @Test
    public void testBaseFallbackFactory() throws Exception {
        // Setup
        BaseUseClientFallbackWithFactory fallback = new BaseUseClientFallbackWithFactory();
        when(mockProviderClient.base()).thenThrow(new NoFallbackAvailableException("fallbackWithFactory", new RuntimeException()));
        when(mockBaseUseProviderClientFallbackFactory.create(any(Throwable.class))).thenReturn((BaseUseClient) fallback);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/base-use")
                .accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

        // Verify the results
        assertEquals("fallbackWithFactory", response.getContentAsString());
    }


}
