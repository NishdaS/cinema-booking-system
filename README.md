
```markdown
# Cinema Booking System – Java Console Application 🎬

> **Unit:** Advanced Programming  
> **Name:** Fathima Nishda Mohomed Semsar  

---

## Project Overview

This console-based Java application simulates a **cinema seat booking system** for a fictional business called **Melbourne Cinema (MC)**. It allows users to:

- Book seats across various pricing categories
- Refund booked seats
- Print formatted booking and refund receipts
- Track seat availability and occupancy
- View a statistical sales report

---

## Technologies Used

- Java (Console application)
- OOP principles (encapsulation, method abstraction)
- JUnit 5 (for unit testing)
- UML class diagram design

---

## Project Structure

```

cinema-booking-system/
├── src/
│   └── com/assignment/mypckg/
│       ├── Cinema.java         # Core business logic
│       ├── Demo.java           # Main class (user interface)
├── test/
│   └── com/assignment/mypckg/
│       └── TestCinema.java     # JUnit tests (3 functions, 3+ test cases each)
├── UML-Diagram.png             # UML for Cinema and Demo classes
├── 104791010\_assignment1.docx  # Assignment report
├── .gitignore
└── README.md

```

---

## How to Run the Program

1. Open the project in any Java IDE (e.g., Eclipse, IntelliJ).
2. Navigate to `Demo.java` inside the `com.assignment.mypckg` package.
3. Run the program.
4. Follow the on-screen prompts to:
   - Book or refund seats
   - View available seats
   - Display booking statistics and receipts

> All input and output occurs in the **console**.

---

## 🧪 Unit Testing

- The `TestCinema` class uses **JUnit 5**.
- It covers 3+ methods with:
  - **2 valid test cases**
  - **1 invalid test case**
- Tested functions include:
  - `bookSeats()`
  - `refundSeats()`
  - `displayReport()`

---

## 📊 Features

- Seat map view with categories (`S`, `P`, `F`)
- Input validation (invalid seat numbers, double booking, over-refund)
- Real-time seat tracking and status updates
- Detailed receipts with per-seat and total cost
- Refund tracking and summaries

---

## 📎 Report Details

- 📄 `Outputs.odf` contains:
  - Problem description
  - Full Java code (copy/pasted, not screenshot)
  - Output screenshots
  - JUnit results
  - UML class diagram

---

## Notes

- No Java Collections (ArrayList, HashMap) used – only arrays and primitive types
- Follows Swinburne’s assignment coding and formatting guidelines
- Includes comments and descriptive variable names throughout

```

---

