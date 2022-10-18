Feature: As a user I want to be to find the company address

  Scenario: Guest user goes to the "Contact Us" page and find the address
    When the user open EPAM web site
    When the user clicks on the "CONTACT US" section
    Then the company address displayed correctly
