Feature: As a user I want to get ability to use top menu section

  Scenario: Order Status page should contains appropriate title
    When the user open web site
    When the user clicks on the "Order Status" section
    Then page with title "View Status of Your Order" is displayed

  Scenario: Contact Us section should contains appropriate title
    When the user open web site
    When the user clicks on the "Contact us" section
    Then page with title "Contact us" is displayed