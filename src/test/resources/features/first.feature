@smoke
Feature: ToDo endpoint get task feature.

  Scenario Outline: Positive case test
    Given Get ToDo API
    When User calls API with id "<todo_id>" as path param
    Then response status should be "<status_code>"
    And body should contain parameter "userId" equals to "<userId>"
    And body should contain parameter "id" equals to "<todo_id>"
    And body should contain parameter "title" equals to "<title>"
    And body should contain parameter "completed" equals to "<completed>"

    Examples:
      | todo_id | status_code | userId | title              | completed |
      | 1       | 200         | 1      | delectus aut autem | false     |
      | 4       | 200         | 1      | et porro tempora   | true      |
      | 4       | 200         | 1      | et porro tempora   | false     |