# mc34i-ejD-3rV1-e2KaA-fD41-pise-2d2nddRt
# Gas Stations Data Management System

### Overview
This project is a Java application for managing gas station data. It includes functionality to fetch gas station data from an external API, parse it, and store it in a PostgreSQL database. Additionally, it provides APIs for retrieving fuel price statistics and searching for gas stations by name.

Features
Fetch gas station data from an external API
Parse JSON data using Gson library
Store data in a PostgreSQL database
Retrieve fuel price statistics
Search for gas stations by name
Technologies Used
Java
Spring Boot
Spring Data JPA
PostgreSQL
Gson
Maven
Setup
Clone the repository:

bash
Copy code
git clone https://github.com/your_username/gas-stations.git
Navigate to the project directory:cd gas-stations
Configure the database connection in application.properties:

Build the project:
mvn clean install

Run the application:

Access the application at http://localhost:8082

API Endpoints
/fuel-prices/stats: Get fuel price statistics
/fuel-prices/stations/search?name={name}: Search for gas stations by name
