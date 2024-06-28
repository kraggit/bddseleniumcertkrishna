#Author: Krishna
#Keywords Summary :
#Feature: Login feature
Feature: Login module related test cases

  Scenario: Test valid login functionaity
    Given User opens the browser
    When User navigated to the Login page
    And User enters user name as 'krishcert' and password as 'project'
    And Clicks on Login button
    Then the home page is displayed

  Scenario: Test invalid login functionaity
    Given User opens the browser
    When User navigated to the Login page
    And User enters user name as 'krishcert' and password as 'kjslj'
    And Clicks on Login button
    Then error message is displayed
