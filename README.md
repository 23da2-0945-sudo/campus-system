# University Student Record and Campus Route Management System

CIT300 – Data Structures and Algorithms
Graded Practical Assignment 1 (Week 10)

## 1. Project Overview

A Java console application that:
- Manages university student records (add, update, delete, search, display)
- Tracks recent actions / undo history
- Processes student service requests in arrival order
- Organizes and searches student records by Student ID
- Models the campus as a graph of locations and roads, with BFS/DFS traversal

## 2. Data Structures Used

| # | Requirement | Implementation | File |
|---|---|---|---|
| 1 | Student record storage | `Student` class | `Student.java` |
| 2 | Linked list | Hand-written singly linked list | `StudentLinkedList.java` |
| 3 | Stack (recent actions/undo) | Hand-written generic linked-node stack | `ActionStack.java` |
| 4 | Queue (service requests) | Hand-written generic linked-node queue | `ServiceQueue.java` |
| 5 | BST (search/organize by ID) | Hand-written Binary Search Tree | `StudentBST.java` |
| 6 | Hashing (fast ID search) | Hand-written hash table, separate chaining | `StudentHashTable.java` |
| 7-11 | Graph (campus locations/roads, BFS/DFS) | Adjacency-list graph | `CampusGraph.java` |
| 12-14 | Menu, validation | Console UI | `Main.java` |

## 3. How to Compile and Run

Requires a JDK (Java 17+ recommended).

```bash
cd src
javac *.java -d ../out
cd ../out
java Main
```

Follow the on-screen numbered menu (1–16) to use every feature.

## 4. Project Structure

```
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

> **Fill this section in with your actual group details before submission — the
> assignment brief requires correct names, IDs, responsibilities, and individual
> contributions, and marks are deducted for missing/incorrect entries.**

| Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| [Full Name] | [Student ID] | Linked list implementation and student-record management (`StudentLinkedList.java`, part of `Main.java`) | [Describe what you personally did] |
| [Full Name] | [Student ID] | Stack and queue implementation (`ActionStack.java`, `ServiceQueue.java`) | [Describe what you personally did] |
| [Full Name] | [Student ID] | BST and hashing/search functionality (`StudentBST.java`, `StudentHashTable.java`) | [Describe what you personally did] |
| [Full Name] | [Student ID] | Graph implementation, campus locations/connections, BFS/DFS (`CampusGraph.java`) | [Describe what you personally did] |

If your group has fewer than 4 members, combine these responsibilities among the
members you have — every component above, including the graph, must still be
completed by someone.

## 6. Notes for Submission

- Push this project to a GitHub repository using branches, commits, and pull
  requests to demonstrate collaboration.
- Record one merged demo video (under 15 minutes) with every member's face
  visible, each showing their own contribution.
- If uploading via Google Drive instead of directly to the LMS, remember to
  give Editor access to `asanka.r@sltc.ac.lk` and `kaushika.w@sltc.ac.lk`
  and double-check the sharing settings before submitting the `.txt` link
  file to the LMS.
