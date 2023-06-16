Feature: Get product details from Amazon
  As a customer, I want to get mobile phone details

  Scenario Outline: Validate the registration page
    Given User is on the Amazon Registration Website "https://www.amazon.com/"
    When User checks the current page title should be "Amazon Registration"
    And User fills in the registration form with "<name>", "<email>", "<password>", and "<reEnterPassword>"
    Then User submits the registration form
    And User closes the Amazon site

    Examples: 
      | name   | email             | password | reEnterPassword |
      | shiva  | shiva12@gmail.com | shiva123 | shiva123        |
      | govind |                   | gov1234  |                 |
      |        | invalid           |          | valid           |

  Scenario: Retrive the product from the amazon
    Given I am on the Amazon website
    When I search for "iPhone 12"
    Then I should see search results
    When I select the first product from the list
    Then I should see the product details
    And close the all browser
