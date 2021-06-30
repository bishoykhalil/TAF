# ZOMATO

### The main Frameworks included in the project:
* Selenium Webdriver
* TestNG
* Allure Report
* Extent Reports
* Apachi POI


### Project Design:
* Page Object Model (POM) design pattern
* Data Driven framework
* Fluent design approach (method chaining)
* Have a supporting Utilities package in *src/main/java* file path, named ***"Utils"*** that includes many wrapper methods in static classes which services as a core engine for the project 



### How to check the execution Log
*To generate Allure Report , Press (Alt + ctrl + t) to open terminal window , then write  (mvn allure::serve) in the terminal
*To check log file , You can find it in the project root path 'app.log'.

### How to run the project main test cases locally:
* A properties file ***"zomato.properties"*** can be found it *src/main/resources* file path including all the configurations needed in the execution
* Can find the test cases in the *src/test/java* folder mainly in the *zomato.test* package
* Can find the test suite for all the  test cases in the *src/test/resources/TestSuits* folder in the *zomato.xml* file
* To start the execution, please make sure that the "execution.type" property is "Local" if you are running locally then right click on the test suite xml file and click Run As >> TestNG Suit 
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `mvn allure:serve` (needs to be able to execute mvn commands); Or you can find the Extent Report ***ExtentReports.html*** in the project root path for the latest execution

