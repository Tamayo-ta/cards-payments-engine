package cards.management.controller;

import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.PinResponse;
import cards.management.service.PinService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static utils.TestUtils.getPinResponse;

class PinManagementControllerTest {
    @Mock
    private PinService pinService;
    @InjectMocks
    private PinManagementController pinManagementController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testChangePinCard() {

        when(pinService.changePin(any())).thenReturn(getPinResponse());

        ResponseEntity<PinResponse> result = pinManagementController.changePinCard(new PinChangeRequest());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(0, result.getBody().getTryNumber());
        Assertions.assertEquals(1, result.getBody().getCode());
        verify(pinService).changePin(any());
    }
}
