# Cinema Booking System – Java Console Application

> **Advanced Programming**
> **Assignment:** Stage C - Object-Oriented Implementation
> **Author:** Fathima Nishda Mohomed Semsar  

---

## Project Overview

This console-based Java application simulates a **cinema seat booking system** for a fictional cinema called **Melbourne Cinema (MC)**. It provides functionalities to:

- Book seats across different pricing categories
- Refund previously booked seats
- Print formatted booking and refund receipts
- Track seat availability and occupancy status
- Generate a statistical sales report

This submission covers **Stage C**, implementing core functionalities using Object-Oriented Programming (OOP) principles, mainly through two classes: `Cinema` and `Demo`.

---

## Technologies Used

- Java (console application)
- Object-Oriented Programming concepts (encapsulation, abstraction)
- JUnit 5 (unit testing framework)
- UML class diagram for design documentation

---

## Project Structure

    cinema-booking-system/
    ├── src/
    │   └── com/assignment/mypckg/
    │       ├── Cinema.java # Core business logic and seat management
    │       ├── Demo.java # Main program with user interface
    │       └── TestCinema.java # JUnit tests for key functionality
    ├── bin/
    │   └── com/assignment/mypckg/
    │       ├── Cinema.class
    │       ├── Demo.class
    │       └── TestCinema.class
    └── README.md

---

## How to Run the Program

1. Open the project folder in any Java IDE (such as Eclipse or IntelliJ IDEA).
2. Locate the `Demo.java` file within the `com.assignment.mypckg` package.
3. Run `Demo.java` as a Java application.
4. Interact with the console prompts to:
   - Book seats by selecting seat category and quantity
   - Refund booked seats
   - View available seats
   - Display booking statistics and receipts

*All input/output is performed through the console.*

---

## Unit Testing

- Unit tests are implemented in the `TestCinema` class using **JUnit 5**.
- Testing covers at least three core methods:
  - `bookSeats()`
  - `refundSeats()`
  - `displayReport()`
- Each method has multiple test cases including:
  - Valid scenarios
  - Invalid input handling

---

## Features

- Seat map display with different categories (`S`, `P`, `F`)
- Input validation for seat selection and booking/refund logic
- Prevention of double bookings and invalid refunds
- Detailed booking and refund receipts printed on demand
- Statistical report summarizing sales and seat occupancy

---

## Report Details

The assignment report (`Outputs.pdf`) contains:

- Problem description and requirements
- Full Java source code (copy-pasted)
- Screenshots of program output and testing
- JUnit testing results
- UML class diagram for the application design

---

*This repository is part of the Advanced Programming unit  and intended for academic purposes only.*
