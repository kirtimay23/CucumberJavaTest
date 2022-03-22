Feature: Add Todo to the Active List

  Scenario Outline: Add Task to the Active List
    Given User is on HomePage of TodoMVC
    When User Enter <Todo> in the Text Box and Press Enter
    Then Verify <Todo> is Added to All List
    And Verify <Todo> is Added to Active List

    Examples: 
      | Todo  |
      | Test1 |
