# LeaderBoard — CSC355 Project 2

A Java program that reads a list of contestants from a file and maintains a sorted leaderboard of the top scorers.

---

## Overview

This project implements a score-based leaderboard using only fixed-size arrays (no ArrayLists). Contestants are read from a CSV file, and a sorted leaderboard is built by inserting each contestant into their correct ranked position. The leaderboard ranks contestants by score (highest first), with alphabetical ordering used as a tiebreaker.

---

## Project Structure

```
Project #2/
├── src/
│   ├── Contestant.java       # Contestant data model
│   ├── LeaderBoard.java      # Sorted leaderboard backed by a fixed-size array
│   └── LeaderBoardTest.java  # Main driver — runs multiple test cases
├── bin/                      # Compiled .class files
├── lib/                      # External dependencies (if any)
├── names.txt                 # Sample input file (name,score format)
├── testOutputSorted.txt      # Expected output for reference
└── Resources/
    └── CSC355.Project2_FA24.pdf  # Original project specification
```

---

## Classes

### `Contestant`
Represents a single contest participant.

| Member | Description |
|--------|-------------|
| `contestantName` | The contestant's name |
| `contestantScore` | Their integer score (default: `-1`) |
| `compareTo(Contestant o)` | Compares by score descending, then name ascending |
| `toString()` | Returns `"Name: Score"` format |

Three constructors are provided: default (no args), name-only, and name + score.

### `LeaderBoard`
Maintains a fixed-size, sorted array of the top-scoring contestants.

| Member | Description |
|--------|-------------|
| `LeaderBoard(int m)` | Creates a board with `m` slots, pre-filled with default contestants |
| `add(Contestant c)` | Inserts a contestant into the correct sorted position if their score qualifies |
| `finalBoard()` | Returns the final sorted `Contestant[]` array |

Insertion works by scanning from index 0 (highest score) and shifting existing entries down when a new contestant's score earns a spot.

### `LeaderBoardTest`
The main driver class. It:
1. Prompts the user for an input filename (default: `names.txt`)
2. Runs several test cases with different values of `N` (contestants read) and `M` (leaderboard size)
3. Prints the input contestants and the final ranked leaderboard for each test

---

## Input File Format

The input file should be a plain text CSV with one contestant per line:

```
Name,Score
```

**Example (`names.txt`):**
```
Mary Smith,5
Anna Adams,10
Emma Bates,1
Elizabeth Carson,9
```

---

## How to Run

### Prerequisites
- Java JDK 8 or higher
- VS Code with the Java Extension Pack (recommended), or any Java IDE / terminal

### Compile

```bash
javac -d bin src/Contestant.java src/LeaderBoard.java src/LeaderBoardTest.java
```

### Run

```bash
java -cp bin LeaderBoardTest
```

When prompted, enter the input filename:
```
Please enter a file name (for default use "names.txt"): names.txt
```

---

## Example Output

```
Start of test 1
Input (N=5):
Mary Smith: 5
Anna Adams: 10
Emma Bates: 1
Elizabeth Carson: 9
Minnie Davidson: 5

Final Leaderboard (M=5):
Anna Adams: 10
Elizabeth Carson: 9
Mary Smith: 5
Minnie Davidson: 5
Emma Bates: 1

End of test 1
```

> When scores are tied, contestants are ordered alphabetically by name.

---

## Design Notes

- **Fixed-size arrays only** — no `ArrayList` or other dynamic collections, per project requirements.
- The leaderboard is built using insertion logic: each new contestant is compared against the current board entries and shifted in if their score is high enough.
- If `N < M` (input size is less than leaderboard size), the program automatically adjusts `N = M` and prints a warning.
- Unmatched or malformed lines in the input file are skipped with an error message.
