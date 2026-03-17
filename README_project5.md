# Hashtable — CSC355 Project 5

A Java implementation of a generic hash table using open addressing with linear probing, lazy deletion, and automatic resizing.

---

## ✅ Completeness Status

**This project is complete.** All required methods in `Hashtable.java` and `Pair.java` are fully implemented:

| Class | Method | Status |
|-------|--------|--------|
| `Pair` | `getKey()`, `getValue()`, `setValue()` | ✅ Complete |
| `Pair` | `equals()`, `toString()` | ✅ Complete |
| `Pair` | `getDeletionStatus()`, `setDeleted()` | ✅ Complete |
| `Hashtable` | `get(K key)` | ✅ Complete |
| `Hashtable` | `put(K key, V val)` | ✅ Complete |
| `Hashtable` | `delete(K key)` | ✅ Complete |
| `Hashtable` | `isEmpty()`, `size()` | ✅ Complete |
| `Hashtable` | `resizeTable()`, `reInsert()` | ✅ Complete |

---

## Overview

This project implements a generic hash table from scratch in Java using:

- **Open addressing with linear probing** for collision resolution
- **Lazy deletion** — deleted entries are flagged rather than immediately removed, preserving probe chains
- **Dynamic resizing** — the table grows when the load factor exceeds 0.5 and shrinks when it drops below 0.125
- **Near-prime table sizes** — resizing uses a helper (`getNextNum`) to pick sizes that are multiples of 6 ± 1, which tend to be prime and reduce clustering

---

## Project Structure

```
Project_5/
├── src/
│   ├── Pair.java           # Generic key-value pair with lazy deletion flag
│   ├── Hashtable.java      # Generic hash table implementation
│   └── HashtableTest.java  # Test driver — runs two test suites
├── bin/                    # Compiled .class files
├── lib/                    # External dependencies (if any)
└── names.txt               # Input data file (Name,Score format)
```

---

## Classes

### `Pair<K, V>`
A generic key-value pair that also tracks whether it has been lazily deleted.

| Member | Description |
|--------|-------------|
| `getKey()` | Returns the key |
| `getValue()` | Returns the value |
| `setValue(V val)` | Updates the value |
| `getDeletionStatus()` | Returns `true` if this pair has been deleted |
| `setDeleted()` | Marks the pair as deleted |
| `equals(Pair p)` | Returns `true` if both key and value match |
| `toString()` | Returns `"(key = K, value = V)"` |

---

### `Hashtable<K, V>`
A generic hash table backed by an array of `Pair` objects.

| Member | Description |
|--------|-------------|
| `Hashtable()` | Default constructor — initial size 11 |
| `Hashtable(int m)` | Constructor with custom initial size |
| `get(K key)` | Returns the value for the given key, or `null` if not found |
| `put(K key, V val)` | Inserts or updates a key-value pair; resizes if load factor exceeds `0.5` |
| `delete(K key)` | Lazily deletes the entry; resizes if load factor drops below `0.125` |
| `isEmpty()` | Returns `true` if the table has no entries |
| `size()` | Returns the number of active key-value pairs |
| `getTable()` | Returns the raw internal array (used for testing only) |

**Load factor thresholds:**
- `αHigh = 0.5` → grow table to `getNextNum(2 * m)`
- `αLow = 0.125` → shrink table to `getNextNum(m / 2)`, minimum size 11

---

### `HashtableTest`
The main test driver. Runs two test suites and prints an expected score.

- **Test 1** — Tests `isEmpty`, `get`, `put` (insert + update), `delete`, and `size` against Java's built-in `HashMap` as a reference.
- **Test 2** — Tests the internal table layout at each stage of insertions and deletions, verifying exact array structure and resize behavior against hardcoded expected arrays.

---

## How to Run

### Prerequisites
- Java JDK 8 or higher
- `names.txt` must be present in the working directory

### Compile

```bash
javac -d bin src/Pair.java src/Hashtable.java src/HashtableTest.java
```

### Run

```bash
java -cp bin HashtableTest
```

---

## Example Output

```
***Begin Test 1***
Testing isEmpty...
Putting some items into the table...
Testing isEmpty...
Testing get...
Testing update...
Testing delete...
Testing get for elements not in the table...
Testing size...
Test 1 Score Expected Score: 15.0

***Begin Test 2***
Test 2 Expected Score: 4.0

Total Part 1 Expected Score: 19.0
```

---

## Design Notes

- **Linear probing** — on collision, the table scans forward one slot at a time, wrapping around with `% m`.
- **Lazy deletion** — entries are marked deleted via a flag rather than being set to `null`. This keeps probe chains intact so `get` can still find keys that were inserted past a now-deleted slot.
- **Two-pass `put`** — first scans for an existing key to update; if none found, rescans for a `null` or deleted slot to insert into.
- **`reInsert`** — used during resize to rehash all non-deleted entries into the new table cleanly.
- **`getNextNum`** — rounds the target size up to the nearest number of the form `6k ± 1`, which has a high probability of being prime and helps distribute hash values evenly.
