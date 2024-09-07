# Smart Home Appliance Control System

This project is a simple **Smart Home Appliance Control Solution** that allows control over different household appliances (Light, Fan, Air Conditioner) via a web-based interface. 
The system supports turning devices on/off, adjusting the fan speed, and setting the air conditioner temperature. 
The system is built using **Spring Boot** for the backend and **HTML, CSS, and JavaScript** for the frontend.
This solution was built for a coding assessment at the request of Medavie Blue Cross as part of the recruitment process.


## Features
- Control **Fan**: Adjust speed (Off, Low, High).
- Control **Light**: Turn on and off.
- Control **Air Conditioner**: Set temperature and turn on/off.

## Technology Stack
- **Back-End**: Spring Boot (Java), H2 Database (for persistence)
- **Front-End**: HTML, CSS, JavaScript
- **Database**: H2 (In-memory for simplicity, no need for external setup)
- **API**: RESTful endpoints for controlling appliances

## Project Structure
```
src/
├── main/
│   ├── java/com/appliances/
│   │   ├── controllers/  # Contains the RESTful controllers
│   │   ├── entities/     # Appliance entities (Fan, Light, AC)
│   │   ├── repositories/ # JPA repositories
│   │   ├── services/     # Business logic for controlling appliances
│   └── resources/
│       ├── static/       # Contains front-end files (HTML, CSS, JS)
│       ├── application.properties # Config for the Spring Boot app
└── test/
```

### Process Overview

### 1. **Project Setup**
The project was built using **Spring Boot** with a REST API that allows you to interact with various appliances. The data is stored using an in-memory **H2 database**, which simplifies the project by not requiring external database setup.

Steps:
- Spring Boot generates the REST endpoints for controlling appliances.
- An in-memory H2 database is used to store appliance states.
- The application starts by loading the statuses of all appliances from the database, showing their current state (On/Off, speed, temperature).

### 2. **Front-End Design**
The front-end consists of a simple **HTML** page styled with **CSS** to control each appliance:
- **Fan**: A slider allows the user to set the fan speed, and icons update dynamically to reflect speed changes.
- **Light**: Buttons are used to turn the light on and off, and the visual indicator updates accordingly.
- **Air Conditioner**: The user can set a temperature or turn it on/off, and the status is displayed.

### 3. **Backend Logic**
- **Controller Layer**: Handles API requests from the front-end and calls the appropriate service methods.
- **Service Layer**: Contains the business logic for controlling the appliances (turning them on/off, setting speed, etc.).
- **Repository Layer**: Manages data persistence using Spring Data JPA with the H2 database.

### 4. **API Endpoints**
- `POST /api/appliances/{id}/on` - Turn on an appliance
- `POST /api/appliances/{id}/off` - Turn off an appliance
- `POST /api/fan/{id}/speed?speed={speed}` - Set fan speed (0 = Off, 1 = Low, 2 = High)
- `POST /airconditioner/{id}/temperature?temperature={temp}` - Set the air conditioner temperature
- `GET /api/appliances/status/all` - Retrieve the status of all appliances

### 5. **Error Handling**
- Error handling is implemented both on the client-side (JavaScript) and server-side (Spring Boot).
- **Client-side**: If a network request fails or if invalid inputs are provided (e.g., invalid temperature), appropriate error messages are displayed to the user.
- **Server-side**: Spring Boot handles invalid requests and database errors, returning the correct HTTP status codes.

### 6. **Polymorphism**
Polymorphism is used to manage different appliance behaviors (e.g., the fan adjusts speed, the light toggles on/off). Each appliance implements an interface to ensure common functionality while allowing each appliance type to handle specific logic.

## How to Run the Project

### Prerequisites
- Java 17 or later
- Maven
- A web browser

### Steps to Run:
1. **Clone the Repository**:
    ```
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Run the Application**:
    Using Maven:
    ```
    mvn spring-boot:run
    ```
    Alternatively, you can package the application and run the jar:
    ```
    mvn clean package
    java -jar target/smart-home-appliance-control-0.0.1-SNAPSHOT.jar
    ```

3. **Access the Application**:
   Open a browser and go to: `http://localhost:8080`

   The front-end page will load, and you can control the appliances (fan, light, and AC) through the provided interface.

### Notes
- The H2 database is in-memory, so all appliance states will reset when the application restarts.
- The status of appliances is fetched when the application starts.
