@smoke
Feature: API Testing
  Scenario: Verify Get call for ReqRes
    When User sends "Get" request to "/api/users/2" endpoint
    Then User verifies Status code is 200
    And  User verifies response body contains following details
      |id|first_name|last_name|email|
      |2 |Janet     |Weaver   |janet.weaver@reqres.in|

  Scenario: Verify Post call for ReqRes
    When User sets following details in request body
      |name      |job|
      |John_1    | SDET|
    When User sends "Post" request to "/api/users" endpoint
    Then  User verifies status code is 201
    And  User verifies the response body contains following details
      |name        |job      |
      |John_1      |SDET     |
