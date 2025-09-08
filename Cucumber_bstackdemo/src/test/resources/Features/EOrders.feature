Feature: Access Orders Page in bstackdemo
Scenario: User clicks orders button, logs in if required, and views orders page
Given user is already signed in, has added products to cart, and checked out
When user clicks the orders button
Then orders page should be displayed

