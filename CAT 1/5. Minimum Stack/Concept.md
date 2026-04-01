# Minimum Stack

## Definition
A **Minimum Stack (Min Stack)** is a special stack data structure that supports standard stack operations along with an additional operation to retrieve the **minimum element** in the stack in constant time.

## Concept
- A stack follows the **Last-In-First-Out (LIFO)** principle
- Accessing or removing elements is allowed only from the top
- Finding the minimum element by traversing the stack is inefficient
- To solve this, an **additional stack** is used to keep track of minimum values

## Operations
- **PUSH** → Insert an element into the stack
- **POP** → Remove the top element from the stack
- **TOP / PEEK** → Retrieve the top element without removing it
- **GETMIN** → Retrieve the minimum element in the stack

## Approach
### Using Two Stacks

This approach maintains:
- **Main Stack** → stores all elements
- **Min Stack** → stores the minimum element corresponding to each state of the main stack

### Key Idea
- Whenever an element is pushed, update the min stack
- The top of the min stack always stores the current minimum
- This allows `getMin()` to work in `O(1)` time

## Algorithm
1. Initialize two stacks:
   - `mainStack`
   - `minStack`
2. **Push(element):**
   - Push the element onto `mainStack`
   - If `minStack` is empty or `element <= top(minStack)`:
     - Push `element` onto `minStack`
   - Else:
     - Push `top(minStack)` again onto `minStack`
3. **Pop():**
   - Pop the top element from both `mainStack` and `minStack`
4. **Top():**
   - Return the top of `mainStack`
5. **GetMin():**
   - Return the top of `minStack`


## Example

Input:
```m
push(5)
push(2)
push(7)
push(1)
getMin()
pop()
top()
getMin()
```


Output:
```
Minimum Element: 1
Top Element: 7
After Pop New Minimum Element: 2
```


## Complexity

**Time Complexity:** `O(1)`  
All operations (`push`, `pop`, `top`, `getMin`) run in constant time.

**Space Complexity:** `O(n)`  
An additional stack is used to store minimum values.

## Interview Notes
- The extra stack ensures constant-time minimum retrieval
- When the minimum element is popped, the min stack is updated automatically
- This approach works with both array-based and linked-list-based stack implementations
