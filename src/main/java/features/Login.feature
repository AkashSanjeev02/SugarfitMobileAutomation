Feature: Login functionality

  @app-launch
  Scenario: TC001 - Verify application launches successfully
    Given Launch the sugar.fit application
    When Verify the login screen is displayed
#    Then Verify the average app load time is within acceptable limits


  @login-success
  Scenario Outline: TC002 - Verify successful login with valid credentials
    Given Launch the sugar.fit application and Verify the login screen is displayed
    When Enter phone number "<phoneNumber>"
    And Click the Send Verification Code button
    And Verify the presence of Enter OTP screen
    And Enter OTP "<otp>"
    Then Verify the presence of Home screen

    Examples:
      | phoneNumber | otp    |
      | 8197471517  | 132465 |

  @login-failure
  Scenario Outline: TC003 - Verify login fails with invalid credentials
    Given The user is on the LoginScreen
    When Enter phone number "<phoneNumber>"
    And Enter OTP "<otp>"
    And Click the login button
    Then Verify error message "<errorMessage>" is displayed

    Examples:
      | phoneNumber  | otp     | errorMessage        |
      | 8197471516   | 000000  | Invalid OTP         |
      | 1234567890   | 132465  | Invalid phone number|
      | 8197471516   | 12345   | Invalid OTP format  |
