# 📚 Problem 15: Library Reservation System


**Data Structures & Algorithms**

## 🎯 Problem Overview

Implement a **Library Reservation System** that efficiently manages book borrowing and returning using fundamental data structures.

The system must support these core rules:

- Books can only be borrowed if copies are available
- Users are placed in a **waiting queue** when no copies are available
- Returned books are **immediately reassigned** to the next waiting user (if any)

## 🧠 Data Structures Used

| Structure          | Purpose                                                                 |
|--------------------|-------------------------------------------------------------------------|
| **Hash Map**       | Key = book title → Value = book info (total copies, available, waitlist) |
| **Queue** (FIFO)   | Stores users waiting for a book (fairness – first come, first served)   |

## 🏛️ System Components

### 📘 Book Record
Each book tracks:

- **Total Copies** — number of copies originally added
- **Available Copies** — copies currently not borrowed
- **Waitlist** — queue of users waiting for this book

### ⚙️ Supported Operations

| Command       | Description                                                                 |
|---------------|-----------------------------------------------------------------------------|
| `ADD_BOOK`    | Add a new book title with specified number of copies                        |
| `BORROW`      | Borrow book if available, else join the waitlist                            |
| `RETURN`      | Return book → immediately give to next waiting user (if any)                |
| `SHOW_BOOK`   | Display current available copies + number of people waiting                |

## ▶️ How to Run

### 📂 Project Structure



### 🐍 Requirements

- Python 3.6+

### 🚀 Execution Steps

```bash
# 1. Clone or download the project
# 2. Open terminal / command prompt

# 3. Navigate to the folder
cd problem15.py

# 4. Run the program
python .problem15.pypy

# On some systems you might need:
python3 problem15..py

