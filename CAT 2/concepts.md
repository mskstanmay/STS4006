# CAT 2 Concepts Combined

## 1. Max Sliding Window (Brute Force)

## What this code does
- Computes the maximum value in every sliding window of size `k` across an array `nums`.
- For each window position `i` from `0` to `n-k`, it scans subarray `nums[i..i+k-1]` to find max.

## Approach
- Check edge conditions (null or empty input).
- Initialize `result` size `n-k+1`.
- For each window start `i`:
  - Set `max` to `Integer.MIN_VALUE`.
  - Loop `j` from `i` to `i+k-1`, update `max = Math.max(max, nums[j])`.
  - Store `max` in `result[i]`.

## Complexity
- Time: O(n*k)
- Space: O(n)

## Dry run example
Input: nums=[1,3,-1,-3,5,3,6,7], k=3
Windows:
- [1,3,-1] -> max=3
- [3,-1,-3] -> max=3
- [-1,-3,5] -> max=5
- [-3,5,3] -> max=5
- [5,3,6] -> max=6
- [3,6,7] -> max=7
Output: [3,3,5,5,6,7]

## Main function
- Creates sample array/`k`, computes output, prints values.

---

## 2. Heap Sort

## What this folder should contain
- An implementation of Heap Sort (build max heap, repeatedly extract max, heapify) is expected here.
- Currently folder may be empty; this document explains the approach.

## Heap Sort algorithm
1. Build max heap from input array (O(n)).
2. For `i = n-1` down to `1`:
   - Swap `arr[0]` (max) with `arr[i]`.
   - Reduce heap size by 1.
   - Heapify root (O(log n)).

## Complexity
- Time: O(n log n)
- Space: O(1) in-place

## Dry run example
Input: [4,10,3,5,1]
- Build max heap: [10,5,3,4,1]
- Swap 10 and 1: [1,5,3,4,10], heapify -> [5,4,3,1,10]
- Swap 5 and 1: [1,4,3,5,10], heapify -> [4,1,3,5,10]
- Swap 4 and 3: [3,1,4,5,10], heapify -> [3,1,4,5,10]
- Continue until sorted: [1,3,4,5,10]

## Note
- Add Java code in this folder under `HeapSort.java` if you want an actual implementation.

---

## 3. Recover BST

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

---

## 4. Tree Views (Horizontal, Vertical, Left, Right, Top, Bottom)

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

---

## 5. Vertical Order Traversal

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

---

## 6. Boundary Traversal

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

---

## 7. BFS, DFS

BFS:

Time Complexity: O(V + E)
Space Complexity: O(V)

DFS:

Time Complexity: O(V + E)
Space Complexity: O(V)

---

## 8. Dial's Algorithm (Bucket-based Shortest Path)

## What this is
- Dial's algorithm finds shortest path in graphs with non-negative small integer edge weights.
- It uses buckets (arrays of lists) instead of priority queue.

## Approach
1. `dist[v] = INF` for all nodes; `dist[source]=0`.
2. Use bucket array indexed by distance (0..maxWeight*V).
3. Relax edges from nodes in increasing bucket index.
4. Move to next non-empty bucket.

## Complexity
- Time: O(V + E + W) where W = max edge weight.
- Space: O(V + W).

## Dry run (conceptual)
Graph edges with weights 0..5. Source=0.
- Start bucket0=[0].
- Relax neighbors of 0 to buckets based on weight.
- Process nodes from lowest non-empty bucket to settle distances.

## Note
- No `Dial's` code exists in this folder; add `DialsAlgorithm.java` to implement fully.

---

## 9. Bellman-Ford Algorithm

## What this code does
- Calculates shortest path in directed graphs with possible negative weights.
- Detects negative weight cycles.

## Approach
1. Initialize `dist[]` to INF, `dist[src]=0`.
2. Repeat `V-1` times:
   - For each edge `(u,v,w)`, if `dist[u] != INF` and `dist[u]+w < dist[v]`, update `dist[v]`.
3. Run one more pass over edges; if any edge can still relax, a negative cycle exists.

## Complexity
- Time: O(V*E)
- Space: O(V + E)

## Dry run example
Graph edges:
0->1(5), 0->2(4), 1->3(3), 2->1(6), 3->2(2), 1->4(-4), 4->2(2)
Source 0: dist after iterations: [0,5,4,8,1]
No negative cycle.

## Main function
- Creates graph, sets edges, calls `BellmanFord(0)`, prints distances.

---

## 10. Topological Sort (Kahn's algorithm)

## What this code does
- Produces a topological ordering of a DAG (directed acyclic graph).
- If a cycle is present, it reports the graph is not a DAG.

## Approach
1. Compute indegree for each vertex.
2. Enqueue all vertices with indegree==0.
3. While queue is not empty:
   - Dequeue `u`, append to ordering.
   - For each neighbor `v` of `u`, decrement indegree[v]. If it becomes 0, enqueue `v`.
4. If visited nodes != total vertices, cycle exists.

## Complexity
- Time: O(V + E)
- Space: O(V)

## Dry run example
Vertices=6, edges: 0->1,0->2,1->3,1->5,2->3,2->5,3->4,5->4
Indegrees: [0,1,1,2,2,2]
Queue start: [0]
Order: [0,1,2,3,5,4]

## Main function
- Builds sample graph and prints topological sort or cycle message.
