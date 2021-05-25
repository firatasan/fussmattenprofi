Feature: Login Func

  Scenario: Login with valid credentials

    Given navigate to fussmattenprofi
    Then open login page
    When enter email and password and click button
    | username | password |
    Then user should login succesfully