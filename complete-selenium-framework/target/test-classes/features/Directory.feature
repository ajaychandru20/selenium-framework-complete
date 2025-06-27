Feature: Directory Checks Validate
  Scenario: Verify the directory details contains mention employee details
#    Given platform navigates to login page
#    Then user enters valid credentials
    And select the Directory navbar, check the field names
    Then select the employee role "HR Manager" in the job title dropdown using "text"
