# Product Management System – College Assignment

This is a Java Spring Boot web application created as part of a college assignment.  
It demonstrates basic CRUD (Create, Read, Update) operations for managing **products** and **categories**, using JSP for the frontend and MySQL for data persistence.

## Directory Structure

```

src/
├─ main/
│  ├─ java/
│  │  └─ com/example/productmanagement/
│  │     ├─ controller/
│  │     ├─ model/
│  │     ├─ repository/
│  │     ├─ service/
│  │     └─ utils/
│  ├─ resources/
│  │  ├─ application.properties
│  │  └─ static/css/
│  └─ webapp/WEB-INF/views/
│     ├─ category/
│     └─ product/
└─ test/
└─ java/com/example/productmanagement/

```

## How to Run

1. **Set up MySQL** and create a database (e.g. `product_db`).
2. Update the `application.properties` file with your database credentials.
3. Open the project in **VS Code** or any IDE.
4. Run the project using:

```

mvn spring-boot\:run

```

Or package and run:

```

mvn clean package
java -jar target/productmanagement-0.0.1-SNAPSHOT.jar


The application will start on [http://localhost:8080](http://localhost:8080)
```

