package com.accreditation.accreditationservice.integration;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AccreditationServiceIntegrationTest {

    private static final String BASE_ENDPOINT = "http://localhost:8090/accreditation-service";
    private static final String ACCREDITATION_USER_ENDPOINT = "/user/accreditation";

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static String readJson(String filename) {
        try {
            return FileUtils.readFileToString(ResourceUtils.getFile("classpath:" + filename), "UTF-8");
        } catch (IOException exception) {
            return null;
        }
    }

    private HttpHeaders buildHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Test
    public void shouldReturn200WhenAccreditationUserWithSuccess() {
        final String payload = readJson("request/accreditattionUserSuccess.json");
        final HttpEntity<String> entity = new HttpEntity<String>(payload, buildHttpHeaders());
        final ResponseEntity<String> response = testRestTemplate.exchange(BASE_ENDPOINT.concat(ACCREDITATION_USER_ENDPOINT),
                HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturn400WhenAccreditationUserWithInvalidRequest() {
        final String payload = readJson("request/invalidAccreditattionUser.json");
        final HttpEntity<String> entity = new HttpEntity<String>(payload, buildHttpHeaders());
        final ResponseEntity<String> response = testRestTemplate.exchange(BASE_ENDPOINT.concat(ACCREDITATION_USER_ENDPOINT),
                HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}