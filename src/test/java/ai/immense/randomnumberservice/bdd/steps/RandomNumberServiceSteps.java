package ai.immense.randomnumberservice.bdd.steps;

import ai.immense.randomnumberservice.RandomNumberServiceApplication;
import ai.immense.randomnumberservice.models.RandomNumberResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration
@SpringBootTest(classes = RandomNumberServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomNumberServiceSteps {

    @Autowired
    public TestRestTemplate restTemplate;

    private ResponseEntity<RandomNumberResponse> randomNumberResponseResponseEntity;

    @Given("the client calls the GET endpoint {string}")
    public void the_client_calls_the_GET_endpoint(String endpoint) {
        randomNumberResponseResponseEntity = restTemplate.getForEntity(endpoint, RandomNumberResponse.class);
    }

    @Then("respond with status {int}")
    public void respond_with_status(int int1) {
        assertEquals( int1, randomNumberResponseResponseEntity.getStatusCodeValue());
    }

    @Then("respond with successful random number response object")
    public void respond_with_successful_random_number_response_object() {
        assertNotNull(randomNumberResponseResponseEntity.getBody());
    }
}
