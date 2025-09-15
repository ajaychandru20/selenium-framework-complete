Feature: Directory Checks Validate

  Scenario: Verify the directory details contains mention employee details
    Then platform allows the user login, and navigate to dashboard
    And select the Directory navbar, check the field names
    Then select the employee role "HR Manager" in the job title dropdown using "text"
