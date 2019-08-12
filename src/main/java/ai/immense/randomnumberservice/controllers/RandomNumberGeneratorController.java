package ai.immense.randomnumberservice.controllers;

import ai.immense.randomnumberservice.models.RandomNumberResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomNumberGeneratorController {


    @GetMapping(path = "/randomnumber")
    public ResponseEntity<RandomNumberResponse> getRandomNumber() {

        Random random = new Random();
        int rand_int1 = random.nextInt(1000);
        RandomNumberResponse randomNumberResponse = new RandomNumberResponse();
        randomNumberResponse.setRandomNumber(rand_int1);
        return ResponseEntity.status(HttpStatus.OK).body(randomNumberResponse);
    }
}
