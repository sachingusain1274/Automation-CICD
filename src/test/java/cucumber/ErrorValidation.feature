
@tag
Feature: Error Validation
  


  @tag2
  Scenario Outline: Error message generation
    Given I landed on Ecommerce Page
    When Logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username  					| password    |  
      | dev@dev.com 				|  Test@1245 	|	

