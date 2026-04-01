# Loop Detection in Singly Linked List
Loop Detection in Singly Linked List using Floyd’s Cycle Detection Algorithm

## Definition  
A **loop (cycle)** in a singly linked list occurs when the `next` reference of a node points to an earlier node in the list instead of pointing to `null`.  
This causes the linked list traversal to repeat indefinitely.


## Concept
- A **singly linked list (SLL)** consists of nodes where each node contains:
  - `data` → value stored in the node  
  - `next` → reference to the next node
- If the last node (or any node) links back to a previous node, a **loop is formed**
- Detecting such loops is important to avoid infinite traversal



## Approach  
### Floyd’s Cycle Detection Algorithm (Tortoise and Hare)

This approach uses **two pointers** moving at different speeds to detect a loop efficiently.

### Key Idea
- Use:
  - **Slow pointer** → moves one step at a time  
  - **Fast pointer** → moves two steps at a time
- If a loop exists, both pointers will eventually meet at the **same node**
- Unlike the basic version, this implementation **returns the data of the node where the pointers meet**



### Steps
1. Initialize two pointers `slow` and `fast` to the head of the linked list
2. Move:
   - `slow` by one node (`slow = slow.next`)
   - `fast` by two nodes (`fast = fast.next.next`)
3. Continue while `fast` and `fast.next` are not `null`
4. If `slow == fast`:
   - A loop is detected
   - Return the `data` of the meeting node
5. If traversal ends without meeting:
   - No loop exists
   - Return `-1`

## Output Explanation

**If a loop exists:**
```Loop found and pointers met at SLNode : <node_data>```

**If no loop exists:**
```No loops present```

## Time and Space Complexity

**Time Complexity:** `O(n)`  
Each pointer traverses the linked list at most once.

**Space Complexity:** `O(1)`  
No extra data structures are used.

