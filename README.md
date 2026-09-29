# University Student Record and Campus Route Management System

CIT300 – Data Structures and Algorithms  
Graded Practical Assignment 1 (Week 10)

## 1. Project Overview

This Java console application manages university student records and campus route data using core data structures such as linked lists, stacks, queues, BSTs, hash tables, and graphs.

The system supports:
- Adding, updating, deleting, and searching student records
- Displaying records in linked-list and BST order
- Tracking recent actions using a stack
- Processing service requests using a queue
- Modeling the campus as an undirected graph with BFS and DFS traversal

## 2. Data Structures Used

| # | Requirement | Implementation | File |
|---|---|---|---|
| 1 | Student record storage | `Student` class | `Student.java` |
| 2 | Linked list | Hand-written singly linked list | `StudentLinkedList.java` |
| 3 | Stack (recent actions / undo history) | Hand-written generic linked-node stack | `ActionStack.java` |
| 4 | Queue (service requests) | Hand-written generic linked-node queue | `ServiceQueue.java` |
| 5 | BST (search / organize by ID) | Hand-written binary search tree | `StudentBST.java` |
| 6 | Hashing (fast ID lookup) | Hand-written hash table with separate chaining | `StudentHashTable.java` |
| 7–11 | Graph (campus locations and roads, BFS/DFS) | Adjacency-list graph | `CampusGraph.java` |
| 12–14 | Menu and validation | Console UI | `Main.java` |

## 3. How to Compile and Run

Requires a JDK (Java 17 or newer is recommended).

```bash
cd src
javac *.java -d ../out
cd ../out
java Main
```

Follow the on-screen numbered menu (1–16) to use all features.

## 4. Project Structure

```text
campus-system/
├── README.md
└── src/
    ├── Student.java
    ├── StudentLinkedList.java
    ├── ActionStack.java
    ├── ServiceQueue.java
    ├── StudentBST.java
    ├── StudentHashTable.java
    ├── CampusGraph.java
    └── Main.java
```

## 5. Group Members and Responsibilities

| Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| N Hasif | 23DA2-0945 | Linked list implementation and student-record management (`StudentLinkedList.java`, part of `Main.java`) | Implemented the `Student` model and custom singly linked list for record storage. |
| M.N. Sahnas Banu | 23DA2-1031 | Stack and queue implementation (`ActionStack.java`, `ServiceQueue.java`) | Implemented the custom stack and queue structures used for actions and service requests. |
| M.K.P. Samrin Sadha | 23DA2-0680 | BST and hashing/search functionality (`StudentBST.java`, `StudentHashTable.java`) | Implemented the binary search tree and hash table for organized storage and fast lookup. |
| A.S.M. Afran | 23DA2-0141 | Graph implementation, campus locations, and BFS/DFS traversal (`CampusGraph.java`) | Implemented the campus graph and traversal logic for location connectivity. |

## 6. Features Included

- Add, update, delete, search, and display student records
- Maintain a recent actions stack
- Queue student service requests in arrival order
- Sort records by student ID using a BST
- Search students quickly with a hash table
- Create campus locations and roads as an undirected graph
- Traverse the campus using BFS or DFS

## 7. Notes for Submission

- Ensure the project is pushed to GitHub with clear commits and branch history.
- Keep the repository organized and include a final working version before submission.
- If required by the lecturer, verify that all team members’ contributions are clearly recorded.
- Confirm that the program runs successfully from the command line before final submission.
"# campus-system" 
"# campus-system" 
