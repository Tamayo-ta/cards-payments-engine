package cards.management.service;

import cards.management.model.entity.CardEntity;
import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.PinResponse;
import cards.management.repository.CardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static utils.TestUtils.getCard;

class PinServiceTest {
    @Mock
    private CardRepository cardRepository;
    @InjectMocks
    private PinService pinService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest(name = "Case {index} -> {3}")
    @MethodSource(value = "changePinParams")
    void testChangePin(PinChangeRequest request, PinResponse response, CardEntity card, String label) {
        when(cardRepository.findByOwnerIdAndNumber(request.getOwnerId(), request.getNumber())).thenReturn(card);

        PinResponse result = pinService.changePin(request);

        Assertions.assertEquals(response.getCode(), result.getCode());
        Assertions.assertEquals(response.getTryNumber(), result.getTryNumber());

        if (card != null && card.getPin().equals(request.getOldPin())) {
            verify(cardRepository).save(any());
        }
        verify(cardRepository).findByOwnerIdAndNumber(request.getOwnerId(), request.getNumber());
    }

    private static Stream<Arguments> changePinParams() {

        PinChangeRequest pinChangeRequest = new PinChangeRequest(1234, 1, 2222, 1234567891234567L);
        PinChangeRequest pinChangeRequest2 = new PinChangeRequest(3333, 1, 2222, 1234567891234567L);
        PinChangeRequest pinChangeRequest3 = new PinChangeRequest(1234, 1, 2222, 1234567891234567L);

        PinResponse pinResponse = new PinResponse(0, 1);
        PinResponse pinResponse2 = new PinResponse(-1, 1);
        PinResponse pinResponse3 = new PinResponse(1, 0);

        CardEntity cardEntity = getCard();

        return Stream.of(
                Arguments.of(pinChangeRequest, pinResponse, cardEntity, "Pin changed successfully"),
                Arguments.of(pinChangeRequest2, pinResponse2, cardEntity, "Old pin not correct"),
                Arguments.of(pinChangeRequest3, pinResponse3, null, "Card number not found"));
    }
}
