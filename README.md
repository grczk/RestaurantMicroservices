# Restaurant Microservices
This application consists of microservices for managing categories and their elements. In this case, it involves dish types and their menu items in a restaurant. Each service in the system is self-contained, responsible for its own domain logic and database, and communicates with other services through REST APIs. The backend is built with Spring Boot and a MySQL database, while the frontend is developed using Angular. The entire application uses Docker for containerization.

## Technologies Used
- **Spring Boot**
- **Angular**
- **REST API**
- **MySQL**
- **Docker**

## Running the Project
1. **Clone the repository**:
    ```bash
    git clone https://github.com/grczk/RestaurantMicroservices.git
    cd RestaurantMicroservices
    ```
2. **Build the project by running the script and start it with docker compose up**:
    ```bash
    ./build.bat
    docker compose up
    ```
3. **Access the Angular frontend**:
   
    The Angular application will be accessible at `http://localhost:8089` on your browser.
![image](https://github.com/user-attachments/assets/b3c85e94-9526-4931-a6ca-eb4d63ca6057)
