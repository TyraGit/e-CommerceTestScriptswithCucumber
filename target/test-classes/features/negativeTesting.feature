Feature: Negative testing

@LoginWithInvalidUsername
Scenario: Login with invalid username
Given User is on landing page
When User login to application with incorrect username
Then Error message toaster should display
Then User is on the Landing page again and browser should quit

@LoginWithInvalidPassword
Scenario: Login with invalid password
Given User is on landing page
When User login to application with incorrect password
Then Error message toaster should display
Then User is on the Landing page again and browser should quit