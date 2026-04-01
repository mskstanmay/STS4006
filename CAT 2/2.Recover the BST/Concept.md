# Recover BST

## What this code does
- Fixes a Binary Search Tree (BST) where two nodes are swapped by mistake.
- Uses in-order traversal to find the two nodes that violate sorted order.
- Swaps their values back to recover the BST.

## Approach
1. In-order traverse the tree (left-root-right) and track `prevNode`.
2. For each `node`, if `prevNode.val >= node.val`, we found anomaly.
   - First anomaly: set `wrongNode1 = prevNode`.
   - Second anomaly (or recurring): set `wrongNode2 = node`.
3. After traversal, swap `wrongNode1.val` and `wrongNode2.val`.

## Complexity
- Time: O(n)
- Space: O(h) recursion stack, where h is tree height.

## Dry run example
Initial tree (swapped nodes 2 and 3):
   3
  / \
 1   4
    /
   2

Inorder before fix: [1,3,2,4]
- First anomaly at 3 > 2: wrongNode1=3, wrongNode2=2
Swap => tree becomes valid BST
Inorder after fix: [1,2,3,4]

## Main function
- Constructs sample tree, recovers it, and prints inorder traversal.