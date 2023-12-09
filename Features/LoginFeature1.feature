Feature: Login

  @Sanity
  Scenario: Successfully Login with Valid Credentials
    Given User Launch Edge Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

  @Regression
  Scenario Outline: Successfully Login with Valid Credentials DDT
    Given User Launch Edge Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enter Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|