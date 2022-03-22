Feature: Delete Completed Todo

  Scenario Outline: Delete Completed Todo
    Given User is on HomePage to Delete Todo
    When User Enter <Todo> in the Box and Press Enter to Add Todo
    And Click on Checkbox to Mark Todo as Complete
    And Click on Clear Completed
    Then Verify <Todo> is removed from All List
    And Verify <Todo> is removed from Completed List
    And Verify <Todo> is removed from Active List

    Examples: 
      | Todo  |
      | Test1 |
