# Stack Permutation

## Definition
A **stack permutation** is a permutation of a given sequence that can be obtained using only **stack operations** such as push and pop.  
Given an original sequence and a target permutation, the task is to determine whether the target permutation can be generated using a stack.

## Concept
- A stack follows the **Last-In-First-Out (LIFO)** principle
- Elements are pushed from the original sequence into the stack
- Elements are popped from the stack to match the target permutation
- If the target sequence can be formed by valid stack operations, it is a valid stack permutation

## Approach
### Stack Simulation Method

This approach simulates stack operations to verify whether a permutation is achievable.

### Key Idea
- Start with an empty stack
- Traverse the original sequence and push elements into the stack
- Whenever the top of the stack matches the next element in the target permutation, pop it
- Continue until all elements are processed

### Steps
1. Create an empty stack
2. Traverse the original sequence one element at a time
3. Push the current element into the stack
4. After each push, check the stack top:
   - If it matches the current target element, pop it
   - Move to the next element in the target sequence
5. After processing all elements:
   - If the stack is empty, the permutation is valid
   - Otherwise, it is not a stack permutation

## Example

Original sequence: `[1, 2, 3]`

Target permutation: `[2, 1, 3]`


Explanation:
- Push `1`, push `2`
- Pop `2`, pop `1`
- Push `3`, pop `3`
- Target permutation is successfully formed

Output: `true`


## Output Explanation
- If all target elements are matched and the stack becomes empty, return `true`
- If elements remain in the stack or matching fails, return `false`

## Time and Space Complexity

**Time Complexity:** `O(n)`  
Each element is pushed and popped at most once.

**Space Complexity:** `O(n)`  
In the worst case, the stack stores all elements from the original sequence.

## Interview Notes
- Stack permutation problems rely on **simulation**
- Order of push is fixed; only pop order can vary
- Not all permutations are possible using a stack
