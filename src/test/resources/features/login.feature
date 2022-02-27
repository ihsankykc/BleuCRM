@login
Feature: User should be able to login

  Scenario: Login as a <userType>
    Given the "help desk user" is on the login page
    When the "help desk user" enters the username password
    Then the "help desk user" should be able to login


  Scenario: Login as a <userType>
    Given the "human resource user" is on the login page
    When the "human resource user" enters the username password
    Then the "human resource user" should be able to login


  Scenario: Login as a <userType>
    Given the "marketing user" is on the login page
    When the "marketing user" enters the username password
    Then the "marketing user" should be able to login


  Scenario Outline:
    Given the "<user>" is on the login page
    When the "<user>" enters the username password
    Then the "<user>" should be able to login
    Examples:
      | user                |
      | help desk user      |
      | human resource user |
      | marketing user      |

