Feature: validate signin page 
Scenario Outline: Check for valid credentials 
Given signin page should be open in default browser
When click on signin button and enter <username> and <password>
And click on loginin button check <status>
Then login successfully and open home page 
Examples:
|username|password|status|
|demouser|testingisfun99|success|
|image_not_loading_user|testingisfun99|success|
|existing_orders_user|testingisfun99|success|
|fav_user|testingisfun99|success|
|locked_user|testingisfun99|success|
