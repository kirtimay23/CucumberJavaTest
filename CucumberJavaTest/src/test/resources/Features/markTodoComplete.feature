Feature: Mark Existing Todo As Complete

  Scenario Outline: Mark Existing Todo As Complete
    Given User is on HomePage to Mark Todo As Complete
    When User Enter <Todo> in the Box and Press Enter
    And User Click on Checkbox to Mark Todo as Complete
    Then Verify <Todo>  is present in All List
    And Verify <Todo>  is present in Completed List

    Examples: 
      | Todo  |
      | Test1 |
