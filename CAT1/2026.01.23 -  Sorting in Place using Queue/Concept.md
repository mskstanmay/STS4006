# Concept
We use a queue to take the elements and do in place sorting for the smallest element and float it to the ending one by one until length of queue is exhausted.

## Goal
To perform sorting of elements without using extra space i.e O(1) space complexity

### To follow
- insertion from rear
- deletion from front

## Steps: 
1. Take all values in a queue
2. Traverse the queue for first time, take the smallest element with it's index position
3. Traverse again and add elements where index != smallest_element.index
4. Add the smallest element at the ending

Example: [10,5,7,8,6]

10 < 2^32
5 < 10

5 is smallest element
Value: `5` Index: `1`

queue after traversal and adding  at end is 
```
Input:       10 5 7 8 6
Iteration 1: 10 7 8 6 5 (5 is floated)
Iteration 2: 10 7 8 5 6 (6 is floated)
Iteration 3: 10 8 5 6 7 (7 is floated)
Iteration 4: 10 5 6 7 8 (8 is floated)
Iteration 5: 5 6 7 8 10 (10 is floated)
```
Space Complexity: O(1)