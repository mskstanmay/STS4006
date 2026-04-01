# Merge Sort in Doubly Linked List
Sorting a doubly linked list using the Merge Sort algorithm

## Definition  
Merge Sort is a **divide and conquer** sorting algorithm that works by dividing a doubly linked list into smaller sublists, recursively sorting them, and then merging the sorted sublists to obtain a fully sorted list.

## Concept
- A **doubly linked list (DLL)** consists of nodes containing:
  - `data` → value stored in the node
  - `prev` → reference to the previous node
  - `next` → reference to the next node
- Merge Sort repeatedly divides the list until sublists contain only one node
- Single-node lists are inherently sorted
- Sorted sublists are merged by rearranging node pointers

## Approach  
Merge Sort Using Divide and Conquer

This approach recursively divides the doubly linked list and merges the sorted halves.

### Key Idea
- Split the list into two halves using slow and fast pointers
- Recursively sort both halves
- Merge the two sorted halves into a single sorted list

### Steps
1. If the list is empty or contains only one node, return it
2. Find the middle node of the list using slow and fast pointers
3. Split the list into two halves at the middle node
4. Recursively apply Merge Sort on both halves
5. Merge the two sorted halves while maintaining correct `prev` and `next` pointers
6. Return the head of the merged sorted list

## Example

Input:
2 <-> 4 <-> 1 <-> 3 <-> 5  

Output:
1 <-> 2 <-> 3 <-> 4 <-> 5  

## Output Explanation
- The list is repeatedly divided until individual nodes remain
- Sorted sublists are merged step by step
- Final output is a fully sorted doubly linked list

## Time and Space Complexity

**Time Complexity:** `O(n log n)`  
The list is divided into halves and merged recursively.

**Space Complexity:** `O(log n)`  
Additional space is used due to recursive function calls.
