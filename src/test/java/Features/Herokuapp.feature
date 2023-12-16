@smoke
Feature: API Testing of HerokuApp
  Scenario: Verify create booking
    When User sets the following details in booking request body
    |firstname|lastname|totalprice|depositpaid|checkin|checkout|additionalneeds|
    |Jim      |Brown   |111       |true       |2018-01-01|2019-01-01|Breakfast |
    When User sends "post" request to "/booking" endpoint
    Then User verifies Status code is 200
    And  User verifies response body contains following details
    |firstname|lastname|totalprice|additionalneeds|
    |Jim      |Brown   |111       |Breakfast |

