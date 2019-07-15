package cards.management.controller.integration;

import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.PinResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.TestUtils.getPinChangeRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PinManagementControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private Integer serverPort;

    @Test
    void testChangePinCard() throws URISyntaxException {

        final String baseUrl = "http://localhost:" + serverPort + "/changePin/";
        URI uri = new URI(baseUrl);

        HttpEntity<PinChangeRequest> request = new HttpEntity<>(getPinChangeRequest());
        ResponseEntity<PinResponse> response = restTemplate.postForEntity(uri, request, PinResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
