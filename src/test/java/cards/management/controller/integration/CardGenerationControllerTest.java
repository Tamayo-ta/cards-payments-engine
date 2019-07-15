package cards.management.controller.integration;

import cards.management.model.request.AssignCardRequest;
import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.CardGenerationResponse;
import cards.management.model.response.PinResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import utils.TestUtils;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.TestUtils.getAssignCardRequest;
import static utils.TestUtils.getPinChangeRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardGenerationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private Integer serverPort;

    @Test
    void testAssignNewCard() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + serverPort + "/assignCard";
        URI uri = new URI(baseUrl);

        HttpEntity<AssignCardRequest> request = new HttpEntity<>(getAssignCardRequest());
        ResponseEntity<CardGenerationResponse> response = restTemplate.postForEntity(uri,request, CardGenerationResponse.class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}
