Feature: Fussmatten(Shop) Functionality Test

  Scenario: Login with valid credentials

    Given navigate to fussmattenprofi
    Then open login page
    When enter email and password and click button
      | test202127 | test202127test |
    Then user should login succesfully

  Scenario: Adding product correctly from Category 1 (Shop) to chart

    Given navigate to shop
    When select random trademark from all
    Then all products should be come from same trademark
    When select a product from a trademark
    Then product should be added succesfully

  Scenario: Buying product correctly from Category 1 (Shop)

    Given navigate to Chart
    Then user can change quantity of item
    When user select quantity of item prise should be correct