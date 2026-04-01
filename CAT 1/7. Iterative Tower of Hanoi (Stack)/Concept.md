# Tower of Hanoi

## Concept
- There are **three stacks (or pegs)**:
  - **Source**
  - **Auxiliary**
  - **Destination**
- Disks of increasing size are initially placed on the **source stack** (`1, 2, 3, ...`)
- The objective is to move all disks to the **destination stack**
- The final order in the destination stack must be the same as the source

## Rules
- Only one disk can be moved at a time
- A larger disk cannot be placed on top of a smaller disk
- All moves must use the three stacks only

## Example

### Odd Number of Disks
Initial state:  
`[1,2,3] , [] , []`

Moves:
- `[2,3] , [] , [1]`
- `[3] , [2] , [1]`
- `[3] , [1,2] , []`
- `[] , [1,2] , [3]`
- `[1] , [2] , [3]`
- `[1] , [] , [2,3]`
- `[] , [] , [1,2,3]`

### Even Number of Disks
Initial state:  
`[1,2] , [] , []`

Moves:
- `[2] , [1] , []`
- `[] , [1] , [2]`
- `[] , [] , [1,2]`

## Observations
- The total number of moves required is: `2^n - 1`
- If the number of disks is **odd**, the first move is made to the **destination** stack
- If the number of disks is **even**, the first move is made to the **auxiliary** stack

## Complexity
- **Time Complexity:** `O(2^n)`
- **Space Complexity:** `O(n)`
