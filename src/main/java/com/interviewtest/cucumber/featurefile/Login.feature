Feature: User Login Feature 

Background: 

	Given User is at the "<login page>" of the application 
	
Scenario Outline: User Login scenario for successful login 
	When User login with the following "<username>" and "<password>" 
	Then User should be able to login with correct"<username>" and "<password>" 
	Examples: 
		| username  | password  |
		| testvisainterview@gmail.com  |Passw0rd1234   |
		
Scenario Outline: User Login scenario for invalid login credentials 

	When User login with the following "username" and "password" 
	Then User should not be able to login with invalid "<username>" and "<password>" 
	Examples: 
		| username  |password |
		|testvisainterview@gmail.com  | Passw0rd12347 |
		|testvisainterview@gmail.com1 |Passw0rd1234|
		
Scenario Outline: User Login and Search for iphone x 64 gb 

	When User login with the following "username" and "password" 
	Then User should be able to login with correct"<username>" and "<password>" 
	Then Search for "iphone x 64 gb" and Select the first phone 
	Then validate product details in the product page 
	Then validate product details in the basket page 
	Examples: 
		| username  |password |
		|testvisainterview@gmail.com  | Passw0rd1234 |
		
		
	