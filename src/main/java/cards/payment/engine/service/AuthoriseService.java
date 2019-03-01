package cards.payment.engine.service;

import cards.payment.engine.model.request.AuthoriseRequest;
import cards.payment.engine.model.response.AuthoriseResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthoriseService {

    public AuthoriseResponse validateAuthorisation(AuthoriseRequest request){
        return new AuthoriseResponse(1,"Aproved","asdasdas-yarwd5a-akdsbasl8d");
    }
}
