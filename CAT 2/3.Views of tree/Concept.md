# Tree Views (Horizontal, Vertical, Left, Right, Top, Bottom)

## What this code does
- Computes multiple tree projections from one binary tree:
  - Horizontal (BFS level order)
  - Vertical (group by horizontal distance)
  - Left and right view (first/last node at each level)
  - Top and bottom view (visible nodes by column)

## Approach per view
- Horizontal: standard BFS queue, report nodes in visit order.
- Vertical: BFS + map `hd -> list`; with `hd` (horizontal distance), left `hd-1`, right `hd+1`.
- Left: for each level, first node visited (i==0).
- Right: for each level, last node visited (i==size-1).
- Top: BFS + map first node per hd.
- Bottom: BFS + map last node per hd.

## Complexity
- Time: O(n)
- Space: O(n)

## Dry run example (tree):
        A
       / \
      B   C
     / \ / \
    D  E F  G

- Horizontal: [A,B,C,D,E,F,G]
- Vertical: [D,B,A,E,F,C,G] (by column)
- Left: [A,B,D]
- Right: [A,C,G]
- Top: [D,B,A,C,G]
- Bottom: [D,E,F,G]

## Main function
- Constructs a sample tree and prints each view.