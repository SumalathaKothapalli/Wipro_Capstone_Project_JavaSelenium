Feature: Search a product in bstackdemo
Scenario Outline: validate search feature
Given login user and search button available
When Enter <item> item and then press search icon
Then List of output relevant to input
Examples:
|item|
|iphone12|
|iphone|
|iphone13|
