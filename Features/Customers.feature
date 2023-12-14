Feature: Customer

@sanity
  Scenario: Add New Customer
  
    Given User launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And click on Login button
    Then User view the dashboard
    When User click on the Customer menu
    And click on the Customer menu item
    And click on Add new button
    Then User can view Add a new customer page
    When User enter all Customer info
    And  click on Save button
    Then User can view the Confirmation message "The new customer has been added successfully."
    And close browser

  
