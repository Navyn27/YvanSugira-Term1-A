package rw.ac.rca.calcapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import rw.ac.rca.calcapp.dto.DoMathRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathControllerEndTest {

    @LocalServerPort
    private int port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testDoMathEndToEnd() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        DoMathRequest request = new DoMathRequest(5, 3, "*");

        HttpEntity<DoMathRequest> requestEntity = new HttpEntity<>(request, headers);

        String url = "http://localhost:" + port + contextPath + "/api/math/doMath";

        ResponseEntity<Double> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Double.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(15.0, responseEntity.getBody());
    }
}
