# InterviewTest
Interview test solution for selenium

Question #1:

1.Create git project on “https://github.com”
2.Create test account on “www.amazon.com”.
3.Write following cucumber/junit test case to login to Amazon and add a product to basket.
4.Logout and login again to amazon
5. Navigate to basket and validate the added product is present or not.
6.Submit completed GIT project and share the URL for review.

Technology can be used ::
Java, Maven ,Git ,  Junit, Cucumber and any other java api required for your testing

 Note::
1.Test should include positive and negative tests flow.
2.Test should generate a test report after test execution.
3.All parameters should be configurable and should have option to control from configuration/properties file.
 

Tests ::
1.Launch “www.amazon.com” page and validate page header
2.Click on login link and Provide incorrect username and validate error.
3.Provide incorrect password and validate error.
4.Provide correct username/password and validate home page header.
5.Search for iphone x 64 gb and click on 1st product and move to product page.
6.Capture product name and price and add 1 quantity to basket
7.Validate product is added into basket on product page
8.Vaidate product price and name on basket page.
9.Logout and login again validate product in basket is present or not.


Question #2:

Given a CSV file where each row contains the name of a city and its state separated by a comma, 
your task is to keep city name only and replace the newlines in the file with semicolons as demonstrated in the sample.

Note: Use only native shell commands

Sample Input:

Atlanta, Ga.
Atlantic City, N.J.
Austin, Texas
Baltimore, Md.
Baton Rouge, La.
Billings, Mont.
Birmingham, Ala.
Bismarck, N.D.
Boise, Idaho
Boston, Mass.
Bridgeport, Conn.

Sample Output:
Atlanta;Atlantic City;Austin;Baltimore;Baton Rouge;Billings;Birmingham;Bismarck;Boise;Boston;Bridgeport
