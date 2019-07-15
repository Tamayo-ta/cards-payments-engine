package cards.management.controller;

import cards.management.model.request.AssignCardRequest;
import cards.management.model.response.CardGenerationResponse;
import cards.management.service.CardGenerationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardGenerationController {

    @Autowired
    private CardGenerationService cardGenerationService;

    @ApiOperation(value = "Create new card for customer")
    @PostMapping(path = "/assignCard", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardGenerationResponse> assignNewCard(@RequestBody AssignCardRequest request) {

        CardGenerationResponse newCard = cardGenerationService.generateCard(request);

        return new ResponseEntity<>(newCard, HttpStatus.OK);
    }
}
