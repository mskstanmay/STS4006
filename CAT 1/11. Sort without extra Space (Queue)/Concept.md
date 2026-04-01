# Sort Queue Without Using Extra Space

## Definition
Sorting a queue **in place** without using any extra data structure, by repeatedly finding the smallest element and moving it to the rear of the queue until all elements are sorted.

## Goal
To sort the elements of a queue using **O(1) extra space**, following standard queue operations.

## Concept
- A **queue** follows the First-In-First-Out (FIFO) principle
- Only two operations are allowed:
  - **Insertion from rear**
  - **Deletion from front**
- The smallest element is identified in each pass and **floated to the end**
- This process continues until the entire queue is sorted

## Approach
### In-Place Selection Sort Using Queue Operations

### Key Idea
- Treat the queue like selection sort
- In each iteration:
  - Find the smallest element in the unsorted portion
  - Move it to the rear of the queue
- Repeat until the length of the queue is exhausted

## Steps
1. Insert all values into the queue
2. Traverse the queue to find the smallest element and its index
3. Traverse the queue again and enqueue all elements except the smallest one
4. Enqueue the smallest element at the rear
5. Repeat the above steps for remaining elements

## Example

Input: `[10, 5, 7, 8, 6]`


Smallest Element Identification:
- `10 < 2^32`
- `5 < 10`
- Smallest element → `5`
- Index → `1`

Queue state after each iteration:
```
Input: 10 5 7 8 6
Iteration 1: 10 7 8 6 5 (5 is floated)
Iteration 2: 10 7 8 5 6 (6 is floated)
Iteration 3: 10 8 5 6 7 (7 is floated)
Iteration 4: 10 5 6 7 8 (8 is floated)
Iteration 5: 5 6 7 8 10 (10 is floated)
```


## Complexity

**Time Complexity:** `O(n^2)`  
Each iteration scans the remaining elements in the queue.

**Auxiliary Space Complexity:** `O(1)`  
Sorting is done in place without using extra data structures.
