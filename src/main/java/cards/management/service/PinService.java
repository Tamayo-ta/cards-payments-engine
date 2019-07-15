package cards.management.service;

import cards.management.model.entity.CardEntity;
import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.PinResponse;
import cards.management.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinService {

    @Autowired
    private CardRepository cardRepository;

    public PinResponse changePin(PinChangeRequest pinChangeRequest){
        PinResponse pinResponse;
        CardEntity card = cardRepository.findByOwnerIdAndNumber(pinChangeRequest.getOwnerId(), pinChangeRequest.getNumber());

        if (card != null){
            if (card.getPin().equals(pinChangeRequest.getOldPin())){
                card.setPin(pinChangeRequest.getNewPin());
                cardRepository.save(card);
                pinResponse = new PinResponse(0,1);
            }else {
                pinResponse = new PinResponse(-1,1);
            }
        }else {
            pinResponse = new PinResponse(1,0);
        }

        return pinResponse;
    }
}
