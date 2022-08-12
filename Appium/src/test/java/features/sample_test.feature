#Author : Rahul Upadhyay
#Date : 12 Aug 2022

Feature: Sample App Sanity

  Scenario Outline: Sample App - SignUp
    Given Sample App is installed & launched
    When User sees "Login" page
    And User tries to login with "<userName>" & "<password>"
    Then User sees "an Error popup" message
    And User closes Error popup message
    When User clicks "SignUp" button
    Then User sees "SignUp" page
    And User Signs Up with "<userName>" & "<password>"
    Then User is "Logged In"
    When User sees "Profile" page
    Then User sees "Profile" Details
    When User clicks "Logout" button
    Then User sees "Login" page


    Examples:
      | userName | password |
      | ra.test  | ra.test  |