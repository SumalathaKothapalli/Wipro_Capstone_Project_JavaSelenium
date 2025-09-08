Feature: Checkout process in bstackdemo
Scenario: Home Page checkout flow
Given user opens the site and adds a product to the cart
And user click on checkout button
And user signs in with valid credentials
When user enters <firstname> <lastname> <address> <state> <postalcode>
Then checkout process completes successfully
Examples:
| firstname | lastname | address    | state         | postalcode |
| demo      | user     | MainStreet | AndhraPradesh | 123456     |
