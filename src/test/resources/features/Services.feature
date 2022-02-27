@services
Feature: User should be able to use Services Funcionality

  Background:


  Scenario:User can suggest "New Idea" under "Ideas" page of "Services" module
    Given the "human resource user" is logged in
    When  the user clicks "Ideas" page "Services" module
    And the user clicks New Idea button
    And creates new idea using following information
      | Title            | new idea         |
      | Idea description | new idea test    |
      | Tags             | #newIdeaTest     |
      | Category         | Services Test |

    And the user clicks Suggest New Idea
    Then new idea should be created


  Scenario: User can like the idea
    Given the "human resource user" is logged in
      When  the user clicks "Ideas" page "Services" module
      And  the user clicks plus sign next to Rating
      Then Like button should be selected

  Scenario: User can like the idea (negative)
    Given the "human resource user" is logged in
    When  the user clicks "Ideas" page "Services" module
    And  the user unclicks plus sign next to Rating
    Then Like button should be unselected

  Scenario: User can dislike the idea
    Given the "human resource user" is logged in
    When  the user clicks "Ideas" page "Services" module
    And  the user clicks minus sign next to Rating
    Then Dislike button should be selected

  Scenario: User can dislike the idea (negative)
    Given the "human resource user" is logged in
    When  the user clicks "Ideas" page "Services" module
    And  the user unclicks minus sign next to Rating
    Then Dislike button should be unselected
@wip
  Scenario:  User can sort the ideas by date added
    Given the "human resource user" is logged in
    When  the user clicks "Ideas" page "Services" module
    And  the user clicks date added button
    Then the user should see the messages sorted by date



