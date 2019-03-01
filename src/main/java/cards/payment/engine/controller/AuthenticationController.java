package cards.payment.engine.controller;

import cards.payment.engine.model.request.AuthoriseRequest;
import cards.payment.engine.model.response.AuthoriseResponse;
import cards.payment.engine.service.AuthoriseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthoriseService authoriseService;

    @ApiOperation(value="get customer")
    @PostMapping(path = "/authorise", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthoriseResponse> authorise(@RequestBody AuthoriseRequest authoriseRequest){

        AuthoriseResponse response = authoriseService.validateAuthorisation(authoriseRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
