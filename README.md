# Employee Timesheet Management Application


## Getting Started

This application was developed using Spring Boot, JPA and Angular.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Angular 10](https://angular.io/guide/setup-local)

## Steps to Setup

** Install latest version of nodejs from https://nodejs.org/en/

** In Eclipse/Spring STS import FeatureRequest Project

Steps : 
- Click on File menu <br/>
- Click on Import sub menu <br/>
- Search for 'Existing projects into Workspace' option and click next <br/>
- Browse folder and click on finish <br/>

** Build the angular code**

go to EmployeeTimeSheetManagement\fecode\employeetimesheetmanagement and run below commands in git bash

```shell
npm install
```
```shell
ng build --prod
```

** Build and run the app using maven**

To build the spring boot project go to EmployeeTimeSheetManagement folder and run below command in git bash

```bash
mvn clean install
```

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `EmployeeTimeSheetManagementApplication` class from your IDE or right click on project EmployeeTimeSheetManagementApplication and run as Spring boot application app.

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

Feature Requests API

Get all employees api :<br/>
- Type :GET<br/>
- Url : /api/v1/employees<br/>

Log work days api :<br/>
- Type : POST<br/>
- Url : /api/v1/work<br/>
- Params : id, workDays<br/>

To apply for vacations api :<br/>
- Type : POST<br/>
- Url :/api/v1/vacation<br/>
- Params : id, workDays<br/>

## Swagger

Swagger UI can be accessed by accessing below url.

http://localhost:8080/swagger-ui.html