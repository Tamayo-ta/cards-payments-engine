package cards.payment.engine.controller;

import cards.payment.engine.model.entity.CardEntity;
import cards.payment.engine.model.request.AssignCardRequest;
import cards.payment.engine.service.CardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsManagementController {

    @Autowired
    private CardService cardService;

    @ApiOperation(value="Create new card for customer")
    @PostMapping(path = "/assignCard", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardEntity> assignNewCard(@RequestBody AssignCardRequest request){

        CardEntity newCard = cardService.generateCard(request);


        return new ResponseEntity<>(newCard, HttpStatus.OK);
    }
}
