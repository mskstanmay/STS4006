import java.util.*;

class Graph {
    private List<List<Integer>> adj;

    // Constructor
    Graph(int v) {
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (directed)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // DFS function
    void dfs(int start) {
        boolean[] visited = new boolean[adj.size()];
        dfsHelper(start, visited);
    }

    // Helper (recursive)
    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfsHelper(nei, visited);
            }
        }
    }

    
}

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        System.out.println("DFS starting from node 0:");
        g.dfs(0);
    }
}