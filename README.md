## Overview of the Implemented Systems

This repository contains two classic undergraduate-level data structures problems that demonstrate practical applications of fundamental concepts: **queues**, **hash tables**, and **circular buffers**.

### Problem 15 – Library Reservation System (Python)

**The Library Reservation System** models the real-world challenge of managing limited book copies in a library when demand exceeds supply. The core idea is to fairly distribute scarce resources while preventing users from being lost in an unfair or chaotic waiting process.

The system uses a **hash map** (Python dictionary) where each key is a book title and each value is a custom `BookDetails` object. This object tracks three essential pieces of information:

- Total number of copies ever added  
- Currently available (not borrowed) copies  
- A **queue** (list used as FIFO) containing the usernames of people waiting for the book

Four main operations are supported:

- `ADD_BOOK` – registers a new title and sets the initial number of copies  
- `BORROW` – either decreases the available count (if > 0) or appends the user to the waitlist  
- `RETURN` – either increases available copies (if nobody is waiting) **or** immediately hands the book to the first person in the queue (dequeuing them)  
- `SHOW_BOOK` – displays current availability and waitlist length

**Key design insight**:  
By combining a hash map for O(1) book lookup with a per-book queue, the system achieves both fast access and **fairness** (first-come-first-served waiting). The most elegant feature is the automatic reassignment on return — no manual intervention is needed when a popular book becomes available again.

This implementation clearly illustrates two of the most frequently used abstract data types in real software: **dictionaries for fast lookup** and **queues for ordered processing**.

### Problem 16 – Tiered Log Archival System (Java)

**The Tiered Log Archival System** simulates how modern logging and monitoring platforms handle high-volume log streams with different retention and access speed requirements.

The system divides storage into three tiers with decreasing access speed but increasing capacity:

- **Hot** tier   – holds the most recent logs (fastest access)  
- **Warm** tier  – medium-term storage  
- **Cold** tier  – long-term archive (slowest access)

Each tier is implemented using a **circular buffer** (also called a ring buffer or circular queue) of fixed size. When a new log arrives:

1. It is always inserted into the **Hot** buffer  
2. If Hot is full → the oldest log is evicted and pushed to **Warm**  
3. If Warm is full → oldest log moves to **Cold**  
4. If Cold is full → oldest log is permanently discarded

Supported operations include:

- `LOG`       – add timestamp + severity + message  
- `QUERY`     – retrieve all logs of a given severity (sorted newest first)  
- `PURGE`     – remove everything older than a given timestamp  
- `STATUS`    – show current number of logs in each tier

**Implementation highlights**:

- Three separate `CircularBuffer` instances manage memory efficiently with O(1) insert and eviction  
- Query collects matching logs from all tiers then sorts them by timestamp (currently using simple list sort)  
- Purge walks each buffer and removes old entries

**Educational value**:  
This design teaches bounded memory management, aging policies, multi-stage buffering, and the trade-off between access speed and retention time — patterns found in real systems such as Kafka, Elasticsearch, Prometheus, CloudWatch, and telemetry pipelines.

### Summary

Both programs solve everyday resource-management problems using different but complementary data structures:

- **Problem 15** → **fast lookup + per-item ordering** (hash map + queue)  
- **Problem 16** → **bounded memory with automatic aging** (multiple circular buffers)

