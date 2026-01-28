# Problem 16: Tiered Log Archival System

## Problem Description
This project implements a tiered log management system for a server cluster.  
Logs arrive continuously and are stored based on recency using three storage tiers:

- **Hot Tier** – Most recent logs (fast access)
- **Warm Tier** – Older logs (medium access)
- **Cold Tier** – Oldest retained logs (slow access)

When a tier reaches capacity, the **oldest log is automatically moved** to the next tier.  
Logs that overflow the Cold tier are permanently deleted.

---

## Data Structures Used

### 1. Circular Arrays
Each tier (Hot, Warm, Cold) is implemented using a **circular array** with fixed capacity.
This allows:
- O(1) insertion
- O(1) eviction of the oldest log
- Efficient tier overflow handling

### 2. Objects
Each log entry is represented as an object containing:
- Timestamp
- Severity (INFO, WARN, ERROR)
- Message

---

## Supported Operations

- **LOG `<timestamp> <severity> <message>`**  
  Inserts a new log into the Hot tier and handles cascading overflow.

- **QUERY `<severity>`**  
  Returns all logs with the given severity across all tiers, sorted by timestamp (newest first).

- **PURGE `<timestamp>`**  
  Deletes all logs older than the given timestamp across all tiers.

- **STATUS**  
  Displays the number of logs in each tier.

---

## How to Compile and Run

1. Navigate to the project directory:
   ```bash
   cd Problem16_TieredLogArchivalSystem


