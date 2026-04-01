import java.util.*;

class Graph {
    private int V; // vertices
    private List<List<Integer>> adj; // adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }   
    }

    // Add edge (undirected)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // remove this line if graph is directed
    }

    // BFS traversal from a source node
    void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}

public class Bfs {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);

        System.out.println("BFS Traversal starting from 0:");
        g.BFS(0);
    }
}