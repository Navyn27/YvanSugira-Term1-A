package rw.ac.rca.calcapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.ac.rca.calcapp.dto.DoMathRequest;
import rw.ac.rca.calcapp.services.MathOperator;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MathControllerIntegrationTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private MathOperator mathOperator;  // Mocking the MathOperator dependency

    @Test
    void testDoMathIntegration() throws Exception {
        // Mock the behavior of MathOperator
        when(mathOperator.doMath(5, 3, "*")).thenReturn(15.0);

        DoMathRequest request = new DoMathRequest(5, 3, "*");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math/doMath")
                        .contentType("application/json")
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.calcResponse").value(15.0));
    }
}
