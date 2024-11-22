#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: Validate Login Scenarios

Background: open browser
Given User Navigate to "loginpage" in "Chrome" browser

@validLogin
Scenario: validate login page with valid credentials
Given User enter username as "Abirami"
And User enter password as "Bullet@123"
When User click on login button
Then Validate user navigated to Homepage

@invalidLogin
Scenario Outline: Validate login page with invalid credentials
Given User enter username as "<username>"
And User enter password as "<password>"
When User click on login button
Then Validate the error message "<msg>"

Examples: 
|username|password|msg|
|Abirami|dummy|Please enter a correct username and password. Note that both fields may be case-sensitive.|
|Sabarish|dummy|Please enter a correct username and password. Note that both fields may be case-sensitive.|

