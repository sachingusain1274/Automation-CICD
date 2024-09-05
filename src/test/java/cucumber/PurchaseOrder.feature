
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Positive Test of Submitting the order
  
  	Background:
		Given I landed on Ecommerce Page
  
  
    Given Logged in with username <username> and password <password>
    When I add product <productName> from Cart
    When Checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on ConfirmPage

    Examples: 
      | username  					| password    |    productName  |
      | dev@dev.com 				|  Test@12345 |			ZARA COAT 3 |
