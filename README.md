# Task-Tracker-Application

Task Tracker Application using Java/ Spring Boot for the
backend and ReactJS for the frontend. The application should provide users with the
ability to manage their tasks, including creating, updating, deleting, and marking tasks as
completed.

## Prerequisites
Before running this application, ensure that you have the following prerequisites in place:

  - Java Development Kit (JDK) 8 or above
  - Node.js and npm (Node Package Manager)
  - MySQL database with a designated schema named "student_management_system"
  - Configure the following properties in the backend's application.properties file:

    ```
    spring.datasource.url: MySQL database url.
    spring.datasource.username: username of MySQL database.
    spring.datasource.password: password of MySQL database.
    ```
    
## Build and Run the Spring Boot Backend
Open a terminal and navigate to the springboot-backend folder.
  - Build the backend application using Maven: Execute the command 
    ```
    mvn clean package
    ```

  - Execute these SQL queries to store user roles in the database:
    ```
    INSERT INTO role (name) VALUES ('ROLE_ADMIN');
    INSERT INTO role (name) VALUES ('ROLE_USER');
    ```
    
  - Run the backend application: Use the command 
    ```
    mvn spring-boot:run
    ```
    
## Install Dependencies and Run the React Frontend
Open another terminal and navigate to the react-frontend folder.
  -  Install dependencies using npm: Run ```npm install```.
  -  Start the React development server: Execute ```npm run dev```.
