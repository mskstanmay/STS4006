# Bellman-Ford Algorithm

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