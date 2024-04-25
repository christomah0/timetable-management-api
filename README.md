# timetable-management-api
## _This project provides a user-friendly RESTful API for managing timetables, built with the powerful Spring Boot framework._

## Features:
- Effortless Establishment Management: Create, retrieve, update, and delete establishment information. (https://www.postman.com/product/rest-client/)
- Level Management: Manage different academic levels within your establishment.
- Additional Functionalities (to be implemented):
    - Manage classes, teachers, and subjects.
    - Build and schedule timetables.
    - Integrate with calendar applications.

## Getting Started
- Prerequisites:
    - Java 11+
    - Maven
- Clone the Project:
```Bash
git clone https://github.com/your-username/timetable-management-api.git
```
- Build and Run:
```Bash
cd timetable-management-api
mvn spring-boot:run
```


## API Reference
The API uses JSON for data exchange and follows the standard HTTP methods for CRUD operations:
- GET: Retrieve data
- POST: Create data
- PUT: Update data
- DELETE: Delete data
## Example Endpoints:
- Establishment Management:
    - List all establishments:
        - GET http://localhost:8080/api/v1/establishment/
    - Get an establishment by ID:
        - GET http://localhost:8080/api/v1/establishment/find?id={establishmentId}
    - Create a new establishment:
        - POST http://localhost:8080/api/v1/establishment/ (with JSON body containing name and address)
    - Update an establishment:
        - PUT http://localhost:8080/api/v1/establishment/update?id={establishmentId} (with JSON body containing updated name and address)
    - Delete an establishment:
        - DELETE http://localhost:8080/api/v1/establishment/delete?id={establishmentId}
- Level Management (similar structure as establishment management):
    - List all levels:
        - GET http://localhost:8080/api/v1/level/
    - ... (other Level API endpoints follow the same pattern)
## Additional Notes:
- Replace {establishmentId} with the actual ID of the establishment you want to access or update.
- Refer to the code for details on additional functionalities planned for future development.
- Contributing
We welcome contributions to this project! Feel free to fork the repository and submit pull requests.
## License
This project is licensed under the MIT License. See the LICENSE file for details.
