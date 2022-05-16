Feature: Login into Amazon Website



@smokeTestDemo
Scenario: Navigating to Signin Page
	Given Initialize the browser with chrome for Amazon Website
	And Navigate to "https://www.amazon.co.uk/" Amazon Website
	And MouseOver on sign link in home page to the signin links
	When Click on sigin links
	Then verify that user is navigated to Sign-in Page
	And close the browser for Amazon Website

@smokeTest
Scenario Outline: Negative test validating login using invalid email
   	Given Initialize the browser with chrome for Amazon Website
	And Navigate to "https://www.amazon.co.uk/" Amazon Website
	And MouseOver on sign link in home page to the signin links
	When Click on sigin links
	Then verify that user is navigated to Sign-in Page
	When User enters emailID <email>
	And User clicks on continue button
	And verify the error message "We cannot find an account with that e-mail address" for "INVALID_EMAIL"
	And close the browser for Amazon Website
	
    
    	Examples: 
		|email             |        
		|t4^%^$$$@gmail.com|

@smokeTest
Scenario Outline: Negative test validating login without email address
   	Given Initialize the browser with chrome for Amazon Website
	And Navigate to "https://www.amazon.co.uk/" Amazon Website
	And MouseOver on sign link in home page to the signin links
	When Click on sigin links
	Then verify that user is navigated to Sign-in Page
	When User enters emailID <email>
	And User clicks on continue button
	And verify the error message "Enter your e-mail address or mobile phone number" for "BLANK_EMAIL"
    And close the browser for Amazon Website
	
    
    	Examples: 
		|email         |password|
		|blank         |128456 |		
		

@dummy
Scenario Outline: Negative test validating login using invalid password
   	Given Initialize the browser with chrome for Amazon Website
	And Navigate to "https://www.amazon.co.uk/" Amazon Website
	And MouseOver on sign link in home page to the signin links
	When Click on sigin links
	Then verify that user is navigated to Sign-in Page
	When User enters emailID <email>
	And User clicks on continue button
	And verify the error message "Enter your e-mail address or mobile phone number" if emailID is blank and close the browser
	And User enters password <password>
	And User clicks on Sign-In button
	Then Sign-In screen will be still there
    And close the browser for Amazon Website
    
    	Examples: 
		|email         |password|
		|test@gmail.com|123456  |
		|blank         |128456 |	
	
