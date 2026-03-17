# Linked Lists — CSC355 Project 3

A Java program implementing and comparing a singly linked list and a doubly linked list, with interactive insertion, deletion, search, and traversal operations.

---

## Overview

This project builds two linked list data structures from scratch and runs them through an interactive menu-driven test driver. After working through each list, the program prints and compares the search times of both implementations in nanoseconds.

---

## Project Structure

```
Project3/
├── src/
│   ├── SimplyLinkedList.java    # Singly linked list implementation
│   ├── DoublyLinkedList.java    # Doubly linked list implementation
│   └── LinkedListTest.java      # Interactive test driver
├── bin/                         # Compiled .class files
└── lib/                         # External dependencies (if any)
```

---

## Classes

### `SimplyLinkedList`
A singly linked list of integers where each node holds a value and a pointer to the next node.

| Method | Description |
|--------|-------------|
| `Insertion(int n, Scanner s)` | Appends `n` user-inputted integers to the end of the list |
| `Deletion(Scanner s)` | Deletes the first node (`F`), last node (`L`), or a node by value (`B`) |
| `Search(int target)` | Searches for a value, prints result, and returns elapsed time in nanoseconds |
| `Traversal()` | Prints all nodes in order as `[v1] <-> [v2] <-> ...` |
| `getHead()` | Returns the head node |

---

### `DoublyLinkedList`
A doubly linked list where each node holds a value and pointers to both the next and previous nodes, enabling bidirectional traversal.

| Method | Description |
|--------|-------------|
| `Insertion(int n, Scanner s)` | Appends `n` user-inputted integers, maintaining `prev` pointers |
| `Deletion(Scanner s)` | Deletes the first node (`F`), last node (`L`), or a node by value (`B`); updates both `next` and `prev` pointers |
| `Search(int target)` | Searches for a value, prints result, and returns elapsed time in nanoseconds |
| `Traversal(Scanner s)` | Prompts for direction: forward (`F`) or backward (`B`) |
| `traverseForward()` | Prints nodes head to tail |
| `traverseBackward()` | Walks to the tail first, then prints tail to head |
| `getHead()` | Returns the head node |

---

## How to Run

### Prerequisites
- Java JDK 8 or higher
- VS Code with the Java Extension Pack, or any Java IDE / terminal

### Compile

```bash
javac -d bin src/SimplyLinkedList.java src/DoublyLinkedList.java src/LinkedListTest.java
```

### Run

```bash
java -cp bin LinkedListTest
```

---

## Usage

The program runs two back-to-back interactive sessions — first for the singly linked list, then the doubly linked list. In each session, enter one of the following commands:

| Input | Operation |
|-------|-----------|
| `I` | Insert — prompts for a count, then reads that many integers |
| `D` | Delete — prompts for `F` (first), `L` (last), or `B` (by value) |
| `S` | Search — prompts for a target value and reports if found + time taken |
| `T` | Traversal — prints the list (doubly linked list also asks for direction) |
| `E` | Exit the current list session |

After both sessions complete, the program prints the search time comparison:

```
Simple List Search Time: 12500.0
Double List Search Time: 9800.0
```

---

## Example Session

```
TEST #1: SIMPLY LINKED LIST
Insert(I), Delete (D), Search (S), Traversal (T), Exit (E)
Input: I
Input Number of Inserts: 3
Input Element: 10
Input Element: 20
Input Element: 30
Next Operation Input: T
[10] <-> [20] <-> [30]
Next Operation Input: D
First (F), Last (L), By Element (B)
Input Option: L
Last Node [30] deleted.
Next Operation Input: E
```

---

## Design Notes

- **Singly linked list** — each node has only a `next` pointer; deletion of the last node requires traversing to the second-to-last node.
- **Doubly linked list** — each node has both `next` and `prev` pointers; deletion at any position updates both neighboring nodes' pointers to maintain list integrity.
- **Search timing** uses `System.nanoTime()` for high-resolution measurement, recorded from the start of the search loop to the moment the element is found (or the list is exhausted).
- **Backward traversal** in the doubly linked list works by first walking to the tail, then following `prev` pointers back to the head.
