Feature: Random Number Service Integration test
  Scenario: Random Number successful generation
    Given the client calls the GET endpoint "/randomnumber"
    Then respond with status 200
    And respond with successful random number response object

  Scenario: Random Number invalid endpoint
    Given the client calls the GET endpoint "/invalidendpoint"
    Then respond with status 404
