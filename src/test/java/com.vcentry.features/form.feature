Feature: Validate the place order form

Background: open formpage in browser
Given User Navigate to "formpage" in "Chrome" browser


@form
Scenario: Validate place order form with valid data
Given User enter "ProductName" as "mobile"
And User enter "MobNum" as "12345678"
And User enter "EmailId" as "this@gmail.com"
And Select Product ctg  as "Electronics"
And User enter "Quantity" as "1"
And User enter "purchaserName" as "Test"
And Select GST applied as "Yes"
And Select Available payment as "cod"
When User click on place order
Then User gets order placed message as "mobile submitted successfully !"
