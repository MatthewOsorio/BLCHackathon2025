# BLCHackathon2025

## How to run backend

### Set up database
1) Install and run database 
    ```
        brew install postgresql
        brew services start postgresql
        psql postgres
    ```

    In psql shell
    ```
        CREATE DATABASE roomie;
        \q
    ```

2) Create a .env file in the root foler and add these lines
    ```
        POSTGRES_URL=jdbc:postgresql://localhost:5432/roomie
        POSTGRES_USER=postgres
        POSTGRES_PASSWORD=postgres_password
    ```

### Install dependencies

3) Install Java17 if you dont have it
    ```
        brew install openjdk@17
    ```

4) Install Maven if you don't have it
    ```
        brew install maven
        mvn clean install
    ```

5) Run project
    ```
        mvn spring-boot:run
    ```

    Then go to <a href= "http://localhost:8080">this link</a>

### API Endpoints

| Method | Endpoint                           | Description                                  |
|--------|------------------------------------|----------------------------------------------|
| GET    | `/student`                         | Retrieve all students (DTO format)           |
| GET    | `/student/{id}/questionnaire`      | Retrieve a student's questionnaire           |
| POST   | `/student`                         | Create a new student                         |
| POST   | `/student/{id}/questionnaire`      | Submit a new questionnaire                   |
| DELETE | `/student/{id}`                    | Delete a student by ID  