Feature: As a user I want to be able to add product to the cart

  Scenario: User is able to add product to the cart
    When the user open web site
    When the user open product "1782483640" details page
    When the user clicks on "Add to basket" button in PDP
    When the user clicks on "Basket / Checkout" button in PDP pop-up
    When the user clicks on "Checkout" button on Cart Page
    Then basket "Sub-total" is equal to basket "Total"


