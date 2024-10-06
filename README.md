# Task Manager Application

## Project Overview
This is a full-stack Task Manager web application that allows users to create, retrieve, update, and delete tasks. The application consists of:
- **Backend (Spring Boot)** for managing RESTful API endpoints and handling database operations.
- **Frontend (React)** for the user interface to interact with the application.

## Technologies Used
 - **Backend**: Spring Boot, Java, Maven.
 - **Frontend**: React, Axios.
 - **Database**: MySQL (or any other Relational database as configured)
 - **Other**: Swagger for API documentation

## Project Structure
- `client/` : Contains the React frontend code.
- `server/` : Contains the Spring Boot backend code.

## How to Run the Application

### 1. Clone the repository:
```
git clone https://github.com/chandramohan0/Task-Manager.git
cd Task-Manager
```

### 2. Backend Setup:
* Navigate to the backend/ directory:
  ```
  cd server
  ```
* Update the database configuration in application.properties (if necessary).
* Run the Spring Boot application:
  ```
  ./mvnw spring-boot:run
  ```
**OR**
* Open the project in your IDE <b>(e.g., Eclipse, IntelliJ).</b>
* Configure Database Connection in application.properties:
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/TaskManagementSystem?createDatabaseIfNotExist=true
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  ```
### 3. Frontend Setup:
* Navigate to the frontend/ directory:
  ```
  cd client
  ```
* Install the dependencies and run the React app:
  ```
  npm install
  npm start
  ```
### 4. Running Both Together:
Once both backend and frontend servers are running, open your browser and go to <b>http://localhost:3000</b> to access the frontend. The frontend will communicate with the backend API running on <b>http://localhost:8080.</b>

### Testing the Backend
Run the backend tests using Maven:
```
./mvnw test
```
### API Documentation
Swagger is integrated into the backend to provide API documentation. After running the backend, access the Swagger UI at:
<b>http://localhost:8080/swagger-ui.html</b>

### Usage
Access the Frontend: Open your browser and navigate to http://localhost:3000.

**Create a Task**: Fill out the form and click "Add Task".

**Update a Task**: Click "Edit" next to a task, modify the details, and submit the form.

**Delete a Task**: Click "Delete" next to the task you want to remove.

**View All Tasks**: The task list will automatically update to reflect any changes.

### Author
<b>Chandra Mohan: </b>
Feel free to reach out via <b><a href="mailto:thechandramohan01@gmail.com">email</b> for any issues or questions.
