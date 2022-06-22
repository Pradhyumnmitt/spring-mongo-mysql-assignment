SpringBoot Assignment with multiple data sources ie MongoDB and MySQL.

I have developed an Employee Management System.

Steps to Configure:
1-> Setup local MySQL Database with name:ems
2-> Setup local MongoDB Database with name:Projects.

I have used MySQL db for storing details of Employees and MongoDB db to keep a record of projects he/she is working on.

API Requests:

GET-> localhost:8080/api/employees-> will show all the employees with respective projects.

GET-> localhost:8080/api/employees/email/{email}-> will find the employee by his email and display his details,it will take email as request parameter

POST->localhost:8080/api/employees-> will create a new employee and assign new projects to him.

example of Request body JSON:
 {
        "firstName": "Pradhyumn",
        "lastName": "Mittal",
        "email": "pradhyumn@gmail.com",
        "projects":[
            {
                "projectName": "Java",
                "projectDuration": "4 Weeks",
                "projectType": "Development",
                "emailId": ""
            }]
}

PUT-> localhost:8080/api/employees/update -> it will update details of an employee or his courses and employee will be identified using email.
eg for request body {
        "firstName": "Pradhyumn",
        "lastName": "Mittal",
        "email": "pradhyumn@gmail.com",
        "projects":[
            {
                "projectName": "Java",
                "projectDuration": "4 Weeks",
                "projectType": "Development",
                "emailId": ""
            }]
}


DELETE->localhost:8080/api/employees/delete ->it will delete details of an employee or his courses

