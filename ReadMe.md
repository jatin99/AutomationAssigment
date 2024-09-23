# Soumita Assignment
## _Automation Practice Project_

- Java 11
- Maven
- TestNG
- Cucumber
- Rest Assured
- Selenium


## Features

- Performs UI and API Automated Tests for both Inwarranty Flow and OutWarranty Flow
- Integrated with Jenkins CI for Continious Testing for UI and API Component 
- Categorizing the Tests in both TestNG and Cucumber
- Performs Parallel Testing and Isolated Tests


## Tech

Framework uses a number of dependencies to work properly:

- Selenium WebDriver
-WebDriver Manager
- TestNG
- Cucumber
- Cucumber TestNG
- Rest Assured
- OpenCSV
- Apache POI
- MySQL JDBC Connector
- JsonSchemaValidator
- Java-Faker
- Gson

## Adding New Dependencies

New Dependencies can be added in pom.xml at root level under dependencies tag

Example
```
<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.1.1</version>
			<scope>test</scope>
		</dependency>
```



## Plugins

Maven Plugins used in the Project
<table>
  <tr><th>Plugin</th><th>README</th></tr>
  <tr><td>Maven SureFire Plugin- </td><td>https://maven.apache.org/surefire/maven-surefire-plugin </td></tr>
    <tr><td> Exec Maven Plugin -</td><td>https://www.mojohaus.org/exec-maven-plugin/ </td></tr>
</table>




### To Run the Automated Test for TestNG from cli...

```sh
mvn -Dexec.classpathScope=test  -Dexec.arguments="api,sanity" test-compile  exec:java -Dexec.cleanupDaemonThreads=false -X
```


### To Run the Automated Test for Cucumber from cli...

```sh
mvn test -X
```



ALlure report (recorded)

Logging log4j (recorded)


Console Log of Android Studio or ChromeInspect!

