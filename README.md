# Queue Ticket System

A backend project developed to simulate a real-world queue management system, inspired by ticket generators used in banks and customer service centers.

The main goal of this project was to practice data structures, design patterns, authentication, and backend architecture using Java and Spring Boot.

---

## Features

* Queue ticket generation
* 3 attendance types:

  * Default
  * Priority
  * PCD
* Queue ordering using `PriorityQueue`
* JWT authentication for admin access
* Factory Method design pattern implementation
* REST API endpoints for queue management
* Random ticket code generation

---

## Queue Priority Logic

The system uses Java's `PriorityQueue` to organize the attendance order.

Priority levels:

```text
PCD = 0
Priority = 1
Default = 2
```

The lower the number, the higher the priority.

If two tickets have the same priority, the system also considers the creation date and time to maintain the correct order.

---

## Technologies Used

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* MySQL
* Docker
* Maven

---

## Design Pattern

This project uses the **Factory Method** design pattern.

A main factory interface is responsible for ticket creation, while each queue type has its own factory implementation.

This helped keep the code:

* More organized
* Decoupled
* Easier to maintain

---

## Admin Routes

After authentication, the admin can:

* Call the next ticket in the queue
* Finish the current attendance

Example routes:

```http
POST /queue/next
POST /queue/finish
```

---

## Running the Project

To run the project, you only need Docker installed.

```bash
docker compose up -d
```

That's it 🚀

---

## What I Learned

With this project, I improved my knowledge in:

* Queue data structures
* Java `PriorityQueue`
* Factory Method pattern
* JWT authentication
* REST API development
* Backend architecture with Spring Boot

---
