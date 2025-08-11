# 📚 Data Structures

A clean and educational Java project implementing core data structures from scratch. This repository helps reinforce the internal working of data structures without relying on built-in Java utilities.

---

## Implemented Data Structures

### 1. Array

A **custom dynamic array** implementation that resizes automatically when capacity is exceeded. Provides constant-time access by index.

**Key Features:**
- Add, remove, and access elements
- Automatic resizing (growth logic)
- Time complexity:
    - Access: O(1)
    - Insertion (end): O(1) amortized
    - Deletion: O(n)

---

### 2. Linked List (Singly)

A **singly linked list** where each node points to the next. Great for dynamic data with frequent insertions/deletions.

**Key Features:**
- Add/delete at head or tail
- Search by value
- Iteration support
- Time complexity:
    - Insertion: O(1) (at head), O(n) (at tail)
    - Deletion/Search: O(n)

---

### 7. Doubly Linked List

An enhanced version of the linked list where each node has both `next` and `prev` pointers, allowing traversal in both directions.

**Key Features:**
- Insert/delete at head, tail, or specific index
- Traverse forward or backward
- More efficient deletions than singly linked list when node reference is known
- Time complexity:
    - Insertion: O(1) at ends, O(n) at index
    - Deletion: O(1) with node reference, O(n) by value

---

### 3. Stack (Linked List-based)

A **stack implemented using a singly linked list**. Follows **LIFO (Last In First Out)**.

**Key Features:**
- `push()` to add element to top
- `pop()` to remove element from top
- `peek()` to view the top element
- Time complexity: O(1) for push/pop/peek

---

### 4. Stack (Array-based)

A **stack backed by a dynamic array**.

**Key Features:**
- Similar operations to LinkedList stack
- Dynamic resizing
- Time complexity:
    - Push: O(1) amortized
    - Pop/Peek: O(1)

---

### 5. Queue (Linked List-based)

A **FIFO (First In First Out)** queue implemented using a linked list.

**Key Features:**
- `enqueue()` to add at rear
- `dequeue()` to remove from front
- Time complexity: O(1) for enqueue/dequeue

---

### 6. Dictionary (Key-Value Store)

A **simple dictionary** (like a basic HashMap) to store key-value pairs.

- A simple array of linked lists (chaining)
- A linear probing array
- Or just a list of key-value entries

**Key Features:**
- `put(key, value)` to insert/update
- `get(key)` to retrieve a value
- `remove(key)` to delete a key
- Time complexity (ideal case): O(1)

---

### 7. Hash Table
**A hash table implementation using FNV-1a hashing for keys and linear probing for collision resolution.
Key Features:**

- set(key, value) to insert or update a key-value pair

- get(key) to retrieve the value for a given key

- Automatic resizing when capacity is reached

- Uses linear probing to handle collisions

- Hash function: FNV-1a 32-bit algorithm

- Time complexity (ideal case):

  - Insertion: O(1)

  - Lookup: O(1)

  - Worst case (full collisions): O(n)

**Implementation details:**

- Stores entries as an array of KeyValuePair objects

- Automatically doubles the capacity when full

- Handles both inserting new keys and updating existing keys

- Prints debug info for hash values and probing during collisions


### 8. Binary Tree
**A binary tree implementation with support for insertion, deletion, searching, and multiple traversal orders.**

**Key Features:**


- Insert(data) – Inserts a node into the first available position (level-order insertion)

- deleteNode(node) – Deletes a node by replacing it with the last node (level-order)

- find(value) – Searches for a node containing the given value


- **Traversals:**

- Pre-order (Root → Left → Right)

- In-order (Left → Root → Right)

- Post-order (Left → Right → Root)


- **Utility functions:**

- height() – Returns the height of the tree

- getLastNode() – Gets the last (rightmost) node

- getParent(node) – Gets a node’s parent

- printTree() – Pretty-prints the tree structure in a human-readable format

**Time complexity (average case):**

- Search: O(log n)

- Insert: O(log n)

- Delete: O(log n)

- Worst case (unbalanced): O(n)



## 📁 Project Structure

- [MyArray.java](src/Array.java) – Custom dynamic array implementation
- [LinkedList.java](src/LinkedList.java) – Singly linked list
- [DoublyLinkedList.java](src/DoublyLinkedList.java) – Doubly linked list
- [ArrayBasedStack.java](src/ArrayBased_Stack.java) – Stack using array
- [LinkedListBasedStack.java](src/Stack.java) – Stack using linked list
- [LinkedListBasedQueue.java](src/Queue.java) – Queue using linked list
- [Dictionary.java](src/Dictionary.java) – Key-value store (dictionary)
- [HashTable.java](src/HashTable.java) - Hash table with FNV-1a hashing & linear probing
- [BinaryTree.java](src/BinaryTree.java) – Binary tree with level-order insertion, deletion, search, and traversal methods
- [Main.java](src/Main.java) – Entry point for testing the structures


