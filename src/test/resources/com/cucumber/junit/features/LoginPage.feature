Feature: As a user I want be able to Login

  @smoke
  Scenario: User with valid credential should be able to login
    When the user open web site
    And the user clicks on the "Sign in/Join" section
    And I enter "bazhan@live.com" in the "Email" field
    And I enter "IRAirina2711" in the "Book Depository password" field
    And I press the "Sign-In" button
    Then "Sign out" section is displayed