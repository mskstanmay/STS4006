# Segregate Even and Odd Nodes in Singly Linked List
Segregating even and odd valued nodes in a singly linked list while maintaining their relative order

## Definition  
Segregation of even and odd nodes in a singly linked list is the process of rearranging the nodes such that all **even-valued nodes appear before odd-valued nodes**, while preserving the original order among even nodes and among odd nodes.

## Concept
- A **singly linked list** contains nodes with:
  - `data` → value stored in the node
  - `next` → reference to the next node
- Nodes are classified based on the value stored:
  - **Even nodes** → data % 2 == 0
  - **Odd nodes** → data % 2 != 0
- The goal is to rearrange nodes, not values, and maintain relative order

## Approach  
Segregation Using Two Separate Lists

This approach uses two temporary linked lists to separately store even and odd nodes.

### Key Idea
- Traverse the original list once
- Attach even-valued nodes to an **even list**
- Attach odd-valued nodes to an **odd list**
- Connect the even list followed by the odd list to get the final segregated list

### Steps
1. Initialize four pointers:
   - `evenHead`, `evenTail` for even nodes
   - `oddHead`, `oddTail` for odd nodes
2. Traverse the original linked list
3. For each node:
   - If the node value is even, add it to the even list
   - If the node value is odd, add it to the odd list
4. After traversal, connect `evenTail.next` to `oddHead`
5. The head of the even list becomes the new head of the linked list

## Example

Input:
1 → 2 → 3 → 4 → 5  

Output:
2 → 4 → 1 → 3 → 5  

Input:
2 → 1 → 6 → 4 → 8  

Output:
2 → 6 → 4 → 8 → 1  

## Output Explanation
**If both even and odd nodes are present:**  
Even nodes appear first followed by odd nodes, maintaining their original order.

**If only even or only odd nodes are present:**  
The list remains unchanged.

## Time and Space Complexity

**Time Complexity:** `O(n)`  
Each node in the linked list is visited exactly once.

**Space Complexity:** `O(1)`  
Only pointer variables are used; no additional data structures are required.
