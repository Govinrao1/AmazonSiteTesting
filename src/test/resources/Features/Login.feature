Feature: Amazon Login
  As a user
  I want to log in to my Amazon account
  So that I can access my account and perform actions

  Scenario: Successful Login
    Given I am on the Amazon homepage "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
    When I click on the Sign In button "Amazon Sign In"
    And I enter my valid email "shiva12@gmail.com"
    And I enter my valid password "shiva123"
    And I click on the Continue button
    Then I should be logged in successfully
