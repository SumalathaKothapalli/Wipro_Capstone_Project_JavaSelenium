Feature: Add To Cart and Delete From Cart in bstackdemo  
Scenario: Add and delete any product  
Given Product is searched on home page
When add product to cart
And Open cart and remove product
Then check product is deleted
