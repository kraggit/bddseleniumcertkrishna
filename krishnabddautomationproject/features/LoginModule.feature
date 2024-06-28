#Author: Krishna
#Keywords Summary :
#Feature: Login feature
Feature: Login module related test cases

  Background: 
    Given User opens the browser
    When User navigated to the Login page

  Scenario: Test valid login functionaity
    And User enters user name as 'krishcert' and password as 'project'
    And Clicks on Login button
    Then the home page is displayed
    And close the browser

  
  Scenario: Test invalid login functionaity
    And User enters user name as 'krishcert' and password as 'kjslj'
    And Clicks on Login button
    Then error message is displayed
    And close the browser
    
    @tag2
    Scenario: Test product addition to cart functionality
    And User enters user name as 'krishcert' and password as 'project'
    And Clicks on Login button
    Then the home page is displayed
    And user clicks on product1 link
    And product page is displayed
    And user clicks on Add to cart button
    And user clicks on Cart link
    And Products page is displayed with added product
    And user clicks on Place order button
    And Place Order modal window is displayed
    And user purchases with details entered
    And close the browser
