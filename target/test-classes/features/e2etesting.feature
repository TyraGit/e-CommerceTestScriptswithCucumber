Feature: End to End Testing

Scenario: Login to application
Given User is on landing page
When User login to application with correct credential
Then User should be on the Home page

Scenario: Add one product to cart
Given User selects a product and clicks Add to Cart
Then Product should be added to cart

Scenario: Order has checked out
Given User checkout the product
When User selects a country
Then Order is submitted

Scenario: Download invoice
Given User downloads order invoice
Then Verify that the invoice is a csv file and delete it from system

Scenario: Logged out from application
Given User is able to see the Sign Out button and clicks on the Sign Out button
Then User is on the Landing page again and browser should quit