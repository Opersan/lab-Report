# Laboratory Report Management System

# User List

> Username : Admin     
> Password : pwd
> authority: Admin  

> Username : Furkan  
> Password : pwd  
> authority: Admin  

> Username : Omer  
> Password : pwd  
> authority: User  

# Installation

You will only need a working maven terminal and JDK 11.

Navigate to the root of the project via command line and execute the command:
```sh
mvn spring-boot:run
```


Default URL : http://localhost:8081/

Console URL : http://localhost:8081/h2-console

For database file changes ##
Reports/Workers file location : jdbc:h2:./reports-file
Users file location : jdbc:h2:./users
