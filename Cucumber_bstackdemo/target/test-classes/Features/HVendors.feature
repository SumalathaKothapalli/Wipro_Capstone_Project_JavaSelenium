Feature: validate the vendors brandwise products in bstackdemo
Scenario Outline: validate vendors feature
Given bstack demo home page opens
When Enter <brand> products list displayed
Then view the whole products of that brand
Examples:
|brand|
|Apple|
|Samsung|
|Oneplus|
|google|