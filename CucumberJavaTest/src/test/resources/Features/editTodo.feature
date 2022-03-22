Feature: Edit Todo from the Active list

  Scenario Outline: Edit Todo from the Active list
    Given User is on HomePage of TodoMVC for Edit
    When User Enter <Todo> in the Text Box and Press Enter for Edit
    And Double-click <Todo> to edit and Update it with <UpdatedTodo>
    Then Verify <UpdatedTodo> is Displayed in All List after Edit
    And Verify <UpdatedTodo> is Displayed in Active List after Edit

    Examples: 
      | Todo  | UpdatedTodo |
      | Test1 | Test2       |
