Feature: Login into Application 

Background: 
	Given Browser is open 
	When navigate to link 
	Then validate the link 

@smokeTest
Scenario:
		Given Initialize the browser with chrome 
	And Navigate to "http://qaclickacademy.com/" Site 
	And Click on login link in home page to land on Secure sign in Page 
		|Mike|London|35|Male|
	When User enters "Mike" and Password "12345"
	Then verify that user is successful logged in <loginStaus> 
	And close the browser 
	
@smokeTest
Scenario Outline: Positive test validating login 
	Given Initialize the browser with chrome 
	And Navigate to "http://qaclickacademy.com/" Site 
	And Click on login link in home page to land on Secure sign in Page 
		|Mike|London|35|Male|
	When User enters <username> and Password <password> 
	Then verify that user is successful logged in <loginStaus> 
	And close the browser 
	
	Examples: 
		|username        |password|loginStaus|
		|test99@gmail.com|123456  |true      |
		|test89@gmail.com|128456  |true      |
		|test79@gmail.com|129456  |true      |
		|test69@gmail.com|127456  |true      |
		
		@smokeTest
		Scenario Outline: Negative test validating login 
			Given Initialize the browser with chrome 
			And Navigate to "http://qaclickacademy.com/" Site 
			And Click on login link in home page to land on Secure sign in Page 
				|Mike|London|35|Male|
			When User enters <username> and Password <password> 
			Then verify that user is successful logged in "false" 
			And close the browser 
			
			Examples: 
				|username        |password|loginStatus|
				|test99@gmail.com|123456  |status     |
				|test89@gmail.com|128456  |status     |
				|test79@gmail.com|129456  |status     |
				|test69@gmail.com|127456  |status     |