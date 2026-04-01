# Boundary Traversal

## What this code does
- Traverses a binary tree boundary in anti-clockwise order:
  1. Root (if not leaf)
  2. Left boundary (excluding leaves)
  3. All leaf nodes (left to right)
  4. Right boundary (excluding leaves, added in reverse)

## Approach
- `isLeaf(node)`: true if no children.
- `addLeftBoundary`: travel left edges, take node values except leaves.
- `addLeaves`: recursively collect all leaves in inorder.
- `addRightBoundary`: travel right edges into stack, then pop to append reverse order.

## Complexity
- Time: O(n)
- Space: O(n) for result + stack

## Dry run example
Tree:
    1
   / \
  2   3
 / \ / \
4  5 6  7
- Left boundary: 2
- Leaves: 4,5,6,7
- Right boundary reversed: 3
Output: [1,2,4,5,6,7,3]

## Main function
- Creates sample tree and prints result from `boundaryTraversal`.