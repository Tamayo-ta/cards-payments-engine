package cards.payment.engine.service;

import cards.payment.engine.model.entity.CardEntity;
import cards.payment.engine.model.request.AssignCardRequest;
import cards.payment.engine.model.response.CardGenerationResponse;
import cards.payment.engine.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class CardGenerationService {

    private static final Long MAX_NUMBER_ALLOWED = 10000000000000000L;
    private static final Integer MAX_CVV_ALLOWED = 1000;
    private static final Integer STANDARD_PIN = 10000;

    private SecureRandom secureRandom = new SecureRandom();

    @Autowired
    private CardRepository cardRepository;

    public CardGenerationResponse generateCard(AssignCardRequest request) {
        CardEntity card = new CardEntity();
        card.setCountry(request.getCountry());
        card.setOwnerId(request.getOwnerId());
        card.setStatus(request.getStatus());
        card.setNumber(generateCardNumber());
        card.setCvv(generateCVV());
        card.setPin(generatePin());

        card = cardRepository.save(card);

        return generationResponse(card);
    }


    private CardGenerationResponse generationResponse(CardEntity card) {
        return new CardGenerationResponse(card.getNumber(), card.getCvv(), card.getPin());
    }

    private Integer generatePin() {
        return secureRandom.nextInt(STANDARD_PIN);
    }

    private Integer generateCVV() {
        return secureRandom.nextInt(MAX_CVV_ALLOWED);
    }

    private Long generateCardNumber() {
        return (long) (Math.random() * MAX_NUMBER_ALLOWED);
    }


}
