Feature: Get product details from Amazon
   As customer 
  I want to get the mobile phone details

  Scenario: Retrive the product from the amazon
    Given I am on the Amazon website
    When I search for "iPhone 12"
    Then I should see search results
    When I select the first product from the list
    Then I should see the product details
    And close the all browser
