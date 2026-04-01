# Vertical Order Traversal

## What this code does
- Prints node values column-wise in a binary tree from leftmost column to rightmost.
- Uses BFS plus a horizontal distance (column index) to maintain level order.

## Approach
1. Keep `verticalMap` (TreeMap) mapping column -> list.
2. BFS queue of `(node, col)` with root at col=0.
3. For each popped node:
   - Append to `verticalMap[col]`.
   - Left child gets `col-1`, right gets `col+1`.
4. Return combined lists of each column in sorted order.

## Complexity
- Time: O(n log m), m = number of columns; practically O(n).
- Space: O(n)

## Dry run example (tree):
        1
       / \
      2   3
     / \ / \
    4  5 6  7

Columns:
- col -2: [4]
- col -1: [2]
- col  0: [1,5,6]
- col +1: [3]
- col +2: [7]
Output groups: [[4],[2],[1,5,6],[3],[7]]

## Main function
- Creates sample tree, calls verticalOrderTraversal, prints result.