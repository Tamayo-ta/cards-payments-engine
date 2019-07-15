package cards.management.service;

import cards.management.model.request.AssignCardRequest;
import cards.management.model.response.CardGenerationResponse;
import cards.management.repository.CardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.TestUtils;

import java.security.SecureRandom;

import static org.mockito.Mockito.*;
import static utils.TestUtils.getCard;

class CardGenerationServiceTest {

    @Mock
    private CardRepository cardRepository;
    @InjectMocks
    private CardGenerationService cardGenerationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGenerateCard() {

        when(cardRepository.save(any())).thenReturn(getCard());

        CardGenerationResponse result = cardGenerationService.generateCard(new AssignCardRequest());
        Assertions.assertEquals(1234567891234567L,result.getNumber());
        Assertions.assertEquals(666,result.getCvv());
        Assertions.assertEquals(1234,result.getPin());
        verify(cardRepository).save(any());
    }
}
