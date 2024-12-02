
Feature: SignIN to Amazon 
  
  Scenario Outline: Sign In with valid Username and password 
    Given The User is in the login page
    When User enters valid "<UserName>", "<Password>" and "<Search>"
    Then User is in the Home Page

    Examples: 
      | UserName                    |Password   |Search|
      | kumarviveksinha10@gmail.com |Vivek@1234 |laptop|
      
