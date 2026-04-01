public class Main {
    static class CreateGraph {
        class CreateEdge {
            int src, dest, weight;

            CreateEdge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        int V, E;
        CreateEdge edge[];

        CreateGraph(int v, int e) {
            V = v;
            E = e;
            edge = new CreateEdge[e];
        }

        void BellmanFord(int src) {
            int dist[] = new int[V];
            for (int i = 0; i < V; ++i)
                dist[i] = Integer.MAX_VALUE;
            dist[src] = 0;
            for (int i = 1; i < V; ++i) {
                for (int j = 0; j < E; ++j) {
                    int u = edge[j].src;
                    int v = edge[j].dest;
                    int w = edge[j].weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                        dist[v] = dist[u] + w;
                }
            }
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                intt w = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
            printSolution(dist);
        }

        void printSolution(int dist[]) {
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; ++i)
                System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        CreateGraph graph = new CreateGraph(V, E);
        graph.edge[0] = graph.new CreateEdge(0, 1, 5);
        graph.edge[1] = graph.new CreateEdge(0, 2, 4);
        graph.edge[2] = graph.new CreateEdge(1, 3, 3);
        graph.edge[3] = graph.new CreateEdge(2, 1, 6);
        graph.edge[4] = graph.new CreateEdge(3, 2, 2);
        graph.edge[5] = graph.new CreateEdge(1, 4, -4);
        graph.edge[6] = graph.new CreateEdge(4, 2, 2);
        graph.BellmanFord(0); // 0 is the source vertex
    }
}