# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using **Java, Java Spring, PostgresSQL as the database, and Spring Security and JWT for authentication control.**

This project was created for the purpose of learning and as a foundation for implementing authentication in various Spring-based projects. It serves as a practical example of how to configure Authentication and Authorization in a Spring application using Spring Security.


## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Braianhenrike/Auth.git
```
2. Install dependencies with Maven.

3. Install [PostgresSQL](https://www.postgresql.org/)

## Usage
Start the application with Maven.

The API will be accessible at http://localhost:8080.

## API Endpoints
The API provides the following endpoints:

```markdown
Copy code
POST /auth/login - Log into the App.

POST /auth/register - Register a new user in the App.
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

## Database
The project utilizes [PostgresSQL](https://www.postgresql.org/) as the database. The necessary database migrations are managed using Flyway.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, commit conventions, and submit your changes in a separate branch.```
