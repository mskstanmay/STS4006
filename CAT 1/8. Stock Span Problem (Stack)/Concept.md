# Stock Span Problem

## Definition
Given an array of stock prices for `n` days, the **stock span** for a day is defined as the number of consecutive days (including the current day) for which the price of the stock was **less than or equal to** today’s price.

The span value for each day is stored in a new array.

---

## Concept
- For each index, compare the current stock price with previous prices
- Count how many consecutive elements on the left are **less than or equal** to the current value
- The first stock price always has a span of `1`
- If the previous price is greater than the current price, the span remains `1`

Rules:
- First element → span is always `1`
- If `current >= previous`, keep moving left and increment the span
- Stop when a value greater than the current price is found

---

## Approach
### Stack-Based Approach

**Intuition:**  
Use a stack to store indices of stock prices.  
Each index in the stack represents a price that has not yet found a higher value on its right.

- The stack helps efficiently skip unnecessary comparisons
- Span is calculated using index differences

### Steps
1. Create an empty stack
2. Traverse the price array from left to right
3. For each index `i`:
   - Pop elements from the stack while `price[i] >= price[stack.peek()]`
   - If the stack becomes empty:
     - `span = i + 1`
   - Else:
     - `span = i - stack.peek()`
4. Push the current index into the stack
5. Store the span value in the result array

---

## Example 1

Input: `[60, 70, 100, 90, 110, 90]`
Output: `[1, 2, 3, 1, 5, 1]`


Explanation:
1. `60` → first price → span = 1
2. `70` ≥ `60` → 1 + 1 = 2
3. `100` ≥ `70`, `60` → 1 + 1 + 1 = 3
4. `90` < `100` → span = 1
5. `110` ≥ all previous → 1 + 1 + 1 + 1 + 1 = 5
6. `90` < `110` → span = 1

---

## Example 2

Input: `[60, 50, 70, 40, 80, 100]`
Output: `[1, 1, 3, 1, 5, 6]`


---

## Stack Intuition Breakdown

For the array: `[60, 50, 70, 40, 80, 100]`


- Push index positions into the stack
- If the stack is empty:
  - `span = i + 1`
- If the stack is not empty:
  - `span = i - stack.peek()`
- Always push the current index after computing span

Notes:
- For `i = 0` → span = `[1]`
- Compare `60` & `50` → stack not empty
- Calculate span using index difference
- This avoids repeated comparisons

---

## Complexity

**Time Complexity:** `O(n)`  
Each element is pushed and popped from the stack at most once.

**Space Complexity:** `O(n)`  
Stack is used to store indices.
