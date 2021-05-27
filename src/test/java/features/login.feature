Feature: Login Func

  Scenario: Login with valid credentials

    Given navigate to fussmattenprofi
    Then open login page
    When enter email and password and click button
    | test202127 | test202127test |
    Then user should login succesfully