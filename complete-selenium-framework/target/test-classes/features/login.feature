Feature: Login

  Scenario: Valid user login
    Given user is on login page
    When user enters valid credentials
    Then user is navigated to the homepage
