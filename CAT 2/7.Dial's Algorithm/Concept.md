# Dial's Algorithm (Bucket-based Shortest Path)

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