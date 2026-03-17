# Binary Search Tree — CSC355

A Java implementation of a Binary Search Tree (BST) that stores integer key-value pairs and tracks node height and subtree size.

---

## Overview

This project builds a Binary Search Tree from scratch supporting insertion, lookup, and various tree metrics. Each node tracks its own height and subtree size, which are updated automatically on every insertion. The test driver verifies all operations against expected values.

---

## Project Structure

```
Project6/
├── src/
│   ├── Node.java              # BST node with key, value, height, and size fields
│   ├── Tree.java              # Binary Search Tree implementation
│   └── BinaryTreeTest.java    # Test driver
├── bin/                       # Compiled .class files
└── lib/                       # External dependencies (if any)
```

---

## Classes

### `Node`
Represents a single node in the BST.

| Field | Description |
|-------|-------------|
| `key` | Integer key used for ordering |
| `value` | Integer value stored at this node |
| `height` | Height of this node's subtree (leaf = 0) |
| `size` | Number of nodes in this node's subtree (inclusive) |
| `left`, `right` | Child node references |

---

### `Tree`
The Binary Search Tree. Maintains a `root` node and tracks the overall tree `size` and `height`.

| Method | Description |
|--------|-------------|
| `put(int key, int value)` | Inserts a new key-value pair, or updates the value if the key already exists |
| `get(int key)` | Returns the value for the given key, or `-1` if not found |
| `contains(int key)` | Returns `true` if the key exists in the tree |
| `isEmpty()` | Returns `true` if the tree has no nodes |
| `size()` | Returns the total number of nodes in the tree |
| `size(int key)` | Returns the subtree size rooted at the given key, or `-1` if not found |
| `height()` | Returns the height of the overall tree |
| `height(int key)` | Returns the height of the node with the given key, or `-1` if not found |

**Private helpers:**

- `insertRecursive` — recursively finds the correct position for a new node and updates `height` and `size` on the way back up
- `searchRecursive` — recursively searches by key; shared by `get` and `contains`
- `heightRecursive` — recursively finds a node and returns its stored height
- `sizeRecursive` — recursively finds a node and returns its stored subtree size
- `getMaxNodeHeight` — returns the greater height of two child nodes, null-safe
- `getNodeSize` — returns a node's size, returning 0 for null nodes

---

## How to Run

### Prerequisites
- Java JDK 8 or higher
- VS Code with the Java Extension Pack, or any Java IDE / terminal

### Compile

```bash
javac -d bin src/Node.java src/Tree.java src/BinaryTreeTest.java
```

### Run

```bash
java -cp bin BinaryTreeTest
```

---

## Expected Output

```
Tree empty? true
Tree size: 0
Tree height: 0

After insertions:
Tree empty? false
Tree size: 7
Tree height: 2

Get values:
Get 10: 100
Get 7: 70
Get 20: -1

Contains key?
Contains 5: true
Contains 20: false

Node heights:
Height of 10 (root): 2
Height of 5: 1
Height of 3 (leaf): 0
Height of 20 (not exist): -1

Subtree sizes:
Size of subtree at 10 (root): 7
Size of subtree at 5: 3
Size of subtree at 3: 1
Size of subtree at 20 (not exist): -1

After updating 7:
Get 7: 77

All tests completed!
```

---

## Design Notes

- **Height** is defined as the number of edges on the longest path from a node to a leaf. Leaf nodes have height `0` and a missing node returns `-1`.
- **Size** counts the number of nodes in a subtree, including the root of that subtree. A missing key returns `-1`.
- **Node metadata is updated on every insertion** — after each recursive call returns, `height` and `size` are recalculated bottom-up so they are always current without a separate traversal.
- **Duplicate keys** trigger a value update in-place rather than inserting a second node.
