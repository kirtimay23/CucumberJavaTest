Feature: Mark Completed Task As Active

  Scenario Outline: Mark Completed Task As Active
    Given User is on HomePage to Mark Todo As Active
    When  Enter <Todo> in the Box and Press Enter
    And User Click on Checkbox to Mark Active Todo as Complete
    And User Click on Checkbox to Mark Completed Todo as Active
    Then Verify <Todo>  is now present in All tab
    And Verify <Todo>  is now present in Active tab

    Examples: 
      | Todo  |
      | Test1 |
