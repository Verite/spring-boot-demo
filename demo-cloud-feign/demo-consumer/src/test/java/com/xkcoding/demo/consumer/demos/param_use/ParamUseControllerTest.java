// package com.xkcoding.demo.consumer.demos.param_use;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.mock.web.MockHttpServletResponse;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
//
// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
// @RunWith(SpringRunner.class)
// @WebMvcTest(ParamUseController.class)
// public class ParamUseControllerTest {
//
//     @Autowired
//     private MockMvc mockMvc;
//
//     @MockBean
//     private ParamUseClient mockParamUseClient;
//
//     @Test
//     public void testParam() throws Exception {
//         // Setup
//         when(mockParamUseClient.param(new Params())).thenReturn("result");
//
//         // Run the test
//         final MockHttpServletResponse response = mockMvc.perform(get("/param-use")
//                         .accept(MediaType.APPLICATION_JSON))
//                 .andReturn().getResponse();
//
//         // Verify the results
//         assertEquals(HttpStatus.OK.value(), response.getStatus());
//         assertEquals("expectedResponse", response.getContentAsString());
//     }
// }
