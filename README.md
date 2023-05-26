# Login-Form

This is a Java Servlet that handles user login functionality. It interacts with a MySQL database to store and retrieve user login information. The servlet receives user input from a login form, validates the input, and performs the necessary database operations.

## Prerequisites
Java Development Kit (JDK)
MySQL database server
Servlet container (e.g., Apache Tomcat)

## Setup
Clone the repository or download the source code files.
Import the project into your Java IDE.
Set up the MySQL database and adjust the database connection details in the LoginServlet class.
Build and deploy the project to your servlet container.

## Usage
Access the login form by navigating to the URL where the servlet is deployed (http://localhost:8080/LoginServlet).
Enter the username, password, and email address in the form and submit the data.
The servlet will store the user information in the MySQL database.
A table displaying all the user records will be rendered in the response.

## Dependencies
The servlet depends on the following libraries:

MySQL Connector/J: JDBC driver for connecting to the MySQL database.
Make sure to include the required JAR files in the project's classpath.

## Contributing
Contributions to this project are welcome. If you encounter any issues or have suggestions for improvements, please feel free to submit a pull request or open an issue.
