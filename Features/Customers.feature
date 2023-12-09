Feature: Customers

  Background: Steps Common for all Scenarios
    Given User Launch Edge Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard

  @Sanity
  Scenario: Add a new Customer

    When User click on customers Menu
    And click on customers menu Items
    And click on Add new button
    Then User can view Add new Customer Page
    When user enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser

  @Regression
  Scenario: Search Customer by Email

    When User click on customers Menu
    And click on customers menu Items
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    And Close browser

  @Regression
  Scenario: Search Customer by Name

    When User click on customers Menu
    And click on customers menu Items
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And Close browser