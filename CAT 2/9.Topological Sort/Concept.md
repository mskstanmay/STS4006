# Topological Sort (Kahn's algorithm)

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