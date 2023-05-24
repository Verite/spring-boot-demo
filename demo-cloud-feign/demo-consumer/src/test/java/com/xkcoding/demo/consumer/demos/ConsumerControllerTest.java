package com.xkcoding.demo.consumer.demos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsumerController.class)
public class ConsumerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpringCloudNacosProviderClient mockProviderClient;

    @Test
    public void testConsumer() throws Exception {
        // Setup
        when(mockProviderClient.call("name")).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/consumer")
                        .param("name", "name")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("result", response.getContentAsString());
    }
}
