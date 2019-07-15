package cards.management.controller;

import cards.management.service.PinService;
import cards.management.model.request.PinChangeRequest;
import cards.management.model.response.PinResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PinManagementController {

    @Autowired
    private PinService pinService;

    @ApiOperation(value = "Changes pin of given card and owner")
    @PostMapping(path = "/changePin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PinResponse> changePinCard(@RequestBody PinChangeRequest request) {

        PinResponse response = pinService.changePin(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
