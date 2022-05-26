Feature: Getting a Home Insurance Quote from Lloyds Bank Website


@smokeTest
Scenario Outline: Navigating to Home Insurance Page from LLoyds Home Page
	Given Initialize the browser for Lloyds Website
	And Navigate to <url> Lloyds Website
	And MouseOver on Products and services menu in Lloyds Home Page
	When Click on Home Insurance sub-menu
	And Click on a Get a quote now link
	Then User landed on Home Insurance Page with Page Title <title>
	And User clicks on Get a quote button
	Then User lands on Home Insurance Journey Page 
	And User clicks on Buildings and Contents Options
	And User Enter Post Code <postCode>
	Then Click on Find Address
	And close the browser for Lloyds Website
	  
    	Examples: 
		|url	  |title             |postCode |        
		|urlLloyds|homeInsuranceTitle|EC1Y 4XX |
		

