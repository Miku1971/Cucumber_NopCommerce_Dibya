
Feature: Login
  

  
  Scenario: Succesful Login with valid credential
  
    Given User launch the Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User give Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    
    When  User click on Logout link
    
    Then page title should be "Your store. Login"
    And close browser
    
    
    Scenario Outline:Succesful Login with valid credential with ddt
    Given User launch the Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User give Email as "<email>" and Password as "<password>"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When  User click on Logout link
    Then page title should be "Your store. Login"
    And close browser
    
    Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin1|
    
    



