## Starbucks Page Test Automation

Framework to test the Starbucks page
https://www.starbucks.com.mx/

1 TEST CASE: check link texts in main nav bar

2 TEST CASE: Validate “Encontramos 14 productos que concuerda con su selección” with the selections of coffee requested
             select the " Mexico Chiapas" option and Validate that description is not null, obtain the text and print it on a log.

3 TEST CASE:  Validate the message “Debes completar el captcha” after fill the login form.

4 TEST CASE: Validate that address appears when a shop is selected.

### libraries:
* Java-SDK: 11
* Bazel: for dependencies management 
* Guice: for dependencies injection
* JUNIT: testing framework.
* Google Truth for assertions
* io.github.bonigarcia webdrivermanager 5.0.2 for web drivers (firefox)

## Usage
To run the framework, use the bazel command:

bazel test //src/test/java/org/google/globant/tests:StarbucksTests --strict_java_deps=OFF

you can reset the bazel build with bazel clean

### Result: 
![screenshot](src/main/resources/suite.jpg)


### Result:
![screenshot](src/main/resources/console.jpg)

## Author

Oscar Andres Montes

oscar.montes@globant.com
