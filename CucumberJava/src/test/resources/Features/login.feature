
Feature: feature to test login functionality


  Scenario: Check login is success
    Given is on login page
    When user enters username and pass
    And clicks on login button
    Then user is navigated to home page


