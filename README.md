# School of automation final project

Implemented UI tests for The Movie Database.

# Technologies
The technologies I implemented are: 

1. Java 17
2. Selenium
3. TestNG
4. Allure for reporting
5. Webdrivermanager to manage the selenium webdrivers

# How to run it
Open the terminal and run the following command inside the repository folder

    mvn clean test

# Reports
Once you have run the tests, to see the reports please run the following command
Make sure you have Allure installed on your machine

    allure serve {allure-results path}

Please note that the repository has a folder called allure-results, so you must use that path to run the reporting tool.

# Customising the tests
Note that there is a file inside **src/test/resources** called *data.properties* Inside there you can change the following so as to change the behaviour of the tests.

 - username: your username
 - password: your password
 - browser: you can choose from the following:
	 - chrome
	 - firefox
	 - edge
 - list_title: the name you want for the list
 - list_description: the description for the list
 - movie_title: the movie you want to add to the list

> Thanks a lot for the opportunity of participating in the SOA. It has been an amazing journey full of challenges. If any questions arise don't hesitate in contacting me. 
