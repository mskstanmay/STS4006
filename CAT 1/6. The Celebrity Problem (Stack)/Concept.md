# Celebrity Problem

> Given a party of `n` people represented as a 2D array, find the celebrity.  
> A celebrity is someone who is **known by everyone** but **knows no one**.

## Approach

### Definition of a Celebrity
- Every other person must know the celebrity.
- The celebrity must not know any other person.

### Stack-Based Candidate Selection
- Push all people (indices `0` to `n-1`) onto a stack.
- While the stack has more than one person:
  - Pop two people `a` and `b`.
  - If `arr[a][b] == 1`, then `a` knows `b` → discard `a`, keep `b`.
  - Otherwise, discard `b`, keep `a`.
- After the process, one potential **candidate** remains.

### Verification Step
- Let the remaining person be `candidate`.
- Verify the following conditions:
  - For all `i ≠ candidate`, `arr[i][candidate] == 1` (everyone knows the candidate).
  - For all `i ≠ candidate`, `arr[candidate][i] == 0` (candidate knows no one).
- If both conditions are satisfied, return `candidate`.
- Otherwise, return `-1` (no celebrity exists).

## Complexity
- **Time Complexity:** `O(n)`  
- **Space Complexity:** `O(n)`

## Notes
- Separate candidate selection from verification for clarity.
- Use meaningful variable names (`a`, `b`, `candidate`).
- Return the celebrity index instead of printing it directly.
- Handle input safely when reading data.
