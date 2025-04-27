Feature: Login to Swag Labs

  Scenario Outline: Display error message for invalid login credentials
    Given user is on the Swag Labs login page
    When user enters "<username>" and "<password>"
    And user clicks the login button
    Then the error message 'Epic sadface: Username and password do not match…' should be displayed

    Examples:
      | username | password  |
      | value1_1 | value1_2  |
