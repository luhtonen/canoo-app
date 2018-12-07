# Canoo Library application

This application consists of 2 separate projects:

- canoo-server - server application implemented with Spring Boot
- canoo-frontend - frontend application implemented with Angular 7

## Server

Server application is built with Spring Boot and connects to MongoDB database.

### Requirements

In order to run the application Java and MongoDB must be installed locally. MongoDB must be running.

### Run server

To start server application change to `canoo-server` directory and run following command:

    ./gradlew bootRun

## Frontend

Frontend is implemented with TypeScript and Angular 7 using angular cli.

### Requirements

In order to run the application Node.js must be installed. For implementation latest LTS version 10 was used.

Before running frontend for the first time, all packages required by this project should be installed. Execute following command in directory `canoo-frontend`:

    npm install

### Run frontend

To start frontend application change to `canoo-frontend` directory and run following command:

    npm start

Application is available at http://localhost:4200

## TODO

Features to be implemented:

- User authentication
- Restricting book deletion to admin users only
