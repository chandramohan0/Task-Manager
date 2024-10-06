# Task Manager - Backend

## Overview
This is the backend service of the Task Manager application. It provides RESTful API endpoints for managing tasks, including creating, reading, updating, and deleting tasks. The backend is built using Spring Boot, and it uses a relational database (such as MySQL) for data persistence.

### Requirements
  * Java: 11 or higher
  * Maven: 3.6 or higher
  * Database: MySQL (or any relational database of your choice)
  * Postman: For API testing (optional)

### Getting Started
#### 1. Clone the Repository
First, clone the repository to your local machine.
```
  git clone https://github.com/chandramohan0/TaskManagementSystem
  cd server
```

#### 2. Configure the Database
You need to configure the database connection in src/main/resources/application.yml. By default, the application uses a MySQL database. Update the file with your own database credentials:
  #### Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/TaskManagementSystem?createDatabaseIfNotExist=true
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
  
  #### Hibernate Settings
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

#### Note:

* If the database does not exist, the application will create it automatically using JPA.
* You can adjust the <b>ddl-auto property</b> to <b>create</b> or <b>validate</b> depending on your environment.

#### 3. Build and Run the Application
Once you’ve configured the database, you can build and run the application using Maven:
  #### Build the application
    ./mvnw clean install
  
  #### Run the Spring Boot application
    ./mvnw spring-boot:run

The application will start at <b>http://localhost:8080</b>.

### API Endpoints
Here are the available API endpoints for managing tasks:

| HTTP Method | Endpoint                  | Description                       |
|-------------|---------------------------|-----------------------------------|
| GET         | `/api/task/id/{id}`      | Retrieve a task by ID             |
| GET         | `/api/task/all`          | Retrieve all tasks                 |
| POST        | `/api/task/add`          | Add a new task                     |
| PUT         | `/api/task/update/id/{id}`| Update a task by ID               |
| DELETE      | `/api/task/delete/id/{id}`| Delete a task by ID               |

### Testing the APIs
#### 1. Using Swagger UI
Once the application is running, you can access the <b><a href="http://localhost:8080/swagger-ui.html">Swagger UI</b> to interact with the API endpoints directly from your browser.
  ```
  #### local development
   http://localhost:8080/swagger-ui.html

  #### AWS EC2 Production
   https://ec2-13-201-20-236.ap-south-1.compute.amazonaws.com:8080/swagger-ui/swagger-ui/index.html#/ 
 ```
#### 2. Using Postman
Alternatively, you can use Postman or any other API testing tool to test the endpoints.

### Running Unit Tests
Unit tests are written using JUnit and Mockito to ensure proper functionality of the service methods and API controllers.

To run the tests, execute the following Maven command:
```
  ./mvnw test
```
This will run all the test cases and display the results in the console.

### Technology Stack
The backend is built using the following technologies:

* Java 11: Primary programming language.
* Spring Boot: For building the RESTful API services.
* Spring Data JPA: For interacting with the database using ORM.
* Hibernate: The default JPA provider for ORM.
* MySQL: The relational database used for storing task data.
* Swagger: For API documentation and testing.
* JUnit & Mockito: For writing and running unit tests.

### Author
<b>Chandra Mohan: </b>
Feel free to reach out via <b><a href="mailto:thechandramohan01@gmail.com">email</b> for any issues or questions.
