Feature: Login functionality

  @app-launch
  Scenario: TC001 - Verify application launches successfully
    Given Launch the sugar.fit application
    When Verify the login screen is displayed

  @login-success
  Scenario Outline: TC002 - Verify successful login with valid credentials
    Given Launch the sugar.fit application and Verify the login screen is displayed
    When Enter phone number "<phoneNumber>"
    And Click the Send Verification Code button
      * Verify the presence of Enter OTP screen
      * Enter OTP "<otp>"
    Then Verify the presence of Home screen

    Examples:
      | phoneNumber | otp    |
      | 8197471516  | 132465 |

  @login-failure
  Scenario Outline: TC003 - Verify login fails with invalid credentials
    Given Launch the sugar.fit application and Verify the login screen is displayed
    When Enter phone number "<phoneNumber>"
    And Click the Send Verification Code button
    And Verify the presence of Enter OTP screen
    And Enter OTP "<otp>"
    Then Verify error message "<errorMessage>" is displayed

    Examples:
      | phoneNumber | otp    | errorMessage            |
      | 8197471516  | 000000 | Otp Verification Failed |
