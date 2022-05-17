Feature: find all super heroes in DB
Scenario: Exist super Heroes on DB
    Given a listing request
    When there are no super heroes registered
    Then it should return me code 404
    And message "No super heroes registered"