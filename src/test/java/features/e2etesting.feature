Feature: End to End Testing

@Login
Scenario: Login to application
Given User is on landing page
When User login to application with correct credential
Then User should be on the Home page

@SearchBox
Scenario: Search product
Given User is on the Home page
When User keys in search box and press Enter
Then Home page should refresh
And Verify product is showing on home page
And Clear Search field

@FilterbyCategories
Scenario: Filter product
Given User is on the Home page
When User clicks on Electronic checkbox
Then Home page should refresh
And Verify products are showing based on the selected filter
And Untick Electronic checkbox

@AddtoCart
Scenario: Add one product to cart
Given User selects a product and clicks Add to Cart
Then Product should be added to cart

@CheckOut
Scenario: Order has checked out
Given User checkout the product
When User selects a country
Then Order is submitted

@DownloadInvoice
Scenario: Download invoice
Given User downloads order invoice
Then Verify that the invoice is a csv file and delete it from system

@Logout
Scenario: Logged out from application
Given User is able to see the Sign Out button and clicks on the Sign Out button
Then User is on the Landing page again and browser should quit