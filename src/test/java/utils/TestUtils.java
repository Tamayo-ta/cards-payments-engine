package utils;

import cards.management.model.entity.CardEntity;
import cards.management.model.request.AssignCardRequest;
import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.CardGenerationResponse;
import cards.management.model.response.PinResponse;

public class TestUtils {

    public static CardEntity getCard(){
        CardEntity card = new CardEntity();
        card.setCountry("GB");
        card.setOwnerId(1);
        card.setStatus(1);
        card.setNumber(1234567891234567L);
        card.setCvv(666);
        card.setPin(1234);

        return card;
    }

    public static CardGenerationResponse getCardGenerationResponse(){
        return new CardGenerationResponse(
                1234567891234567L,
                666,
                1234
        );
    }

    public static PinResponse getPinResponse(){
        return new PinResponse(1,0);
    }

    public static PinChangeRequest getPinChangeRequest(){
        return new PinChangeRequest(1411,1,2727,2000909709703266L);
    }

    public static AssignCardRequest getAssignCardRequest(){
        return new AssignCardRequest("ES",1,6);
    }
}
