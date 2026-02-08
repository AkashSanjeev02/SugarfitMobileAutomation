Feature: Manual Meal Logging
  As a user of the Sugar.fit app
  I want to manually log my food consumption
  So that I can track my glucose levels and nutritional intake

  @SuccessfulLogging
  Scenario Outline: Normal submission with 1-2 items from suggestions
    Given User is Logged in and on the Home screen: "<PhoneNumber>" "<Otp>"
    And the user taps on the Plus icon at the bottom tab bar
    And the user selects from the logging options "<LogOption>"
    When the user selects "<LogMethod>" from the Select Method screen
    And the user selects the "<MealSlot>" meal slot
    And the user searches and Selects for "<FoodItem1>" in the search bar
    And the user searches and Selects for "<FoodItem2>" in the search bar
    And the user taps on the Log button
    And the message ThingsYoureDoingRight should be visible

  Examples:
    | LogOption | LogMethod    | MealSlot     | FoodItem1               | FoodItem2 |
    | Food      | Log Manually | PreBreakfast | TeaWithMilkWithoutSugar | PlainCurd |