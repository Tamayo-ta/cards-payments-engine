package cards.management.controller;

import cards.management.model.request.AssignCardRequest;
import cards.management.model.response.CardGenerationResponse;
import cards.management.service.CardGenerationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static utils.TestUtils.getCardGenerationResponse;

class CardGenerationControllerTest {
    @Mock
    private CardGenerationService cardGenerationService;
    @InjectMocks
    private CardGenerationController cardGenerationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAssignNewCard() {
        when(cardGenerationService.generateCard(any())).thenReturn(getCardGenerationResponse());

        ResponseEntity<CardGenerationResponse> result = cardGenerationController.assignNewCard(new AssignCardRequest());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1234567891234567L, result.getBody().getNumber());
        assertEquals(666, result.getBody().getCvv());
        assertEquals(1234, result.getBody().getPin());
        verify(cardGenerationService).generateCard(any());
    }
}
