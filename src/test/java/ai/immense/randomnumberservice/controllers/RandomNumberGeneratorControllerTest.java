package ai.immense.randomnumberservice.controllers;

import ai.immense.randomnumberservice.models.RandomNumberResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RandomNumberGeneratorControllerTest {

    private RandomNumberGeneratorController randomNumberGeneratorController;

    @Before
    public void setUp() {
        randomNumberGeneratorController = new RandomNumberGeneratorController();
    }

    @Test
    public void getRandomNumber_successful_scenario() {
        ResponseEntity<RandomNumberResponse> randomNumberResponseResponseEntity = randomNumberGeneratorController.getRandomNumber();
        assertNotNull(randomNumberResponseResponseEntity);
        assertEquals(HttpStatus.OK, randomNumberResponseResponseEntity.getStatusCode());
        RandomNumberResponse randomNumberResponse = randomNumberResponseResponseEntity.getBody();
        assertNotNull(randomNumberResponse);
    }


}
