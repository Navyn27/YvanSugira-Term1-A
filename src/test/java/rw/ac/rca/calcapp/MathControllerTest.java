package rw.ac.rca.calcapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.ac.rca.calcapp.controllers.MathController;
import rw.ac.rca.calcapp.dto.DoMathRequest;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathController.class)
public class MathControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        void testDoMath() throws Exception {
            DoMathRequest request = new DoMathRequest(5, 3, "*");
            String jsonRequest = objectMapper.writeValueAsString(request);

            mockMvc.perform(MockMvcRequestBuilders.post("/api/math/doMath")
                            .contentType("application/json")
                            .content(jsonRequest))
                    .andExpect(status().isOk())
                    .andExpect( content().contentType("application/json"))
                    .andExpect((ResultMatcher) jsonPath("$.calcResponse").value(15.0));
        }
    }
