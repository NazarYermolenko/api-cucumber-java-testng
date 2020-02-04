# To execute test using maven you should execute 'mvn clean test -Dcucumber.options="--tags @smoke"'
# To generate reports 'mvn cluecumber-report:reporting'

@smoke
Feature: To Do API endpoint.

  Scenario Outline: Positive tests
    User calls API endpoint which should return valid data about a task.

    When User calls API with id "<todo_id>" as path param
    Then response status should be "<status_code>"
    And body should contain parameter "userId" equals to "<userId>"
    And body should contain parameter "id" equals to "<todo_id>"
    And body should contain parameter "title" equals to "<title>"
    And body should contain parameter "completed" equals to "<completed>"

# The third test will fail, it's necessary for example for reporting
    Examples:
      | todo_id | status_code | userId | title              | completed |
      | 1       | 200         | 1      | delectus aut autem | false     |
      | 4       | 200         | 1      | et porro tempora   | true      |
      | 4       | 200         | 1      | et porro tempora   | false     |