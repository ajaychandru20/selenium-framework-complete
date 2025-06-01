Feature: Login HMRC Portal and Validate the Home pages

  Scenario: Verify the portal allows the users to login with valid credentials
    Given platform navigates to login page
    When user enters valid credentials
    Then platform allows the user login, and navigate to dashboard
