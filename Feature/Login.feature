Feature: Login with Valid Credentials


  @sanity
  Scenario: login test
    Given launch browser
    And Open url "https://demo.nopcommerce.com/"
    When Click on login button
    And Enter Email "usharani@gmail.com" password "Sgp@61612"
    And click on login
    Then validate welcome to our store text
    And click on logout button

 
