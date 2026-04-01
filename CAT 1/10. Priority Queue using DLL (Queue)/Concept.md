# Priority Queue Using Doubly Linked List

## Queue Concept
A **Queue** is a linear data structure that follows the **First-In-First-Out (FIFO)** principle.

`FRONT <- [ A, B, C, D ] -> REAR`


- Elements are inserted from the **rear**
- Elements are removed from the **front**

## Types of Queues
- **Simple Queue**
  - Insertion at rear
  - Deletion from front
- **Double Ended Queue (Deque)**
  - Insertion and deletion from both ends
- **Priority Queue**
  - Elements are processed based on priority
  - Types:
    - Highest priority first
    - Lowest priority first

## Queue Implementations
Queues can be implemented using:
1. Array
2. Linked List
3. Binary Search Tree

## Queue Operations
- **enqueue** → Add an element to the queue
- **dequeue** → Remove an element from the queue
- **poll / peek** → Access the front element without removing it

    When a queue is implemented using a Linked List or BST, the operations of those data structures can also be utilized.

---

# Priority Queue

## Definition
A **Priority Queue** is a queue in which each element is associated with a **priority**, and elements are dequeued based on their priority rather than their insertion order.

- Higher priority elements are served first
- If priorities are equal, FIFO order is followed

## Concept
- Unlike a simple queue, order depends on **priority**
- Priority queues are commonly used in:
  - CPU scheduling
  - Dijkstra’s algorithm
  - Task scheduling systems

---

## Implementing Priority Queue Using Doubly Linked List

## Node Structure
Each node in the doubly linked list contains **four fields**:
1. `prev` → reference to the previous node
2. `priority` → priority value of the element
3. `data` → actual data stored
4. `next` → reference to the next node

## Approach
- The doubly linked list is maintained in **sorted order of priority**
- The node with the **highest priority** is always placed at the **head**
- Insertion is done at the correct position based on priority
- Removal (dequeue) happens from the head

## Key Idea
- While inserting a new node:
  - Traverse the list to find the correct position
  - Insert the node such that priority order is maintained
- Doubly linked list allows easy traversal and insertion using `prev` and `next`

## Example

Elements: `1, 3, 2, 4, 5`

Priorities: `5, 3, 4, 2, 1`


After insertion (sorted by priority):

Head

`[data=1, priority=5] <=> [data=3, priority=3] <=> [data=2, priority=4] ...`


- Highest priority element is always closest to the head
- Dequeue operation removes the head node

## Operations Supported
- **Insert(data, priority)** → Inserts element based on priority
- **Dequeue()** → Removes highest priority element
- **Peek()** → Returns highest priority element without removing it

## Time and Space Complexity

**Insertion Time Complexity:** `O(n)`  
Traversal is required to find the correct position.

**Deletion Time Complexity:** `O(1)`  
Removal is done directly from the head.

**Space Complexity:** `O(n)`  
Space is required to store `n` elements in the doubly linked list.
