import java.util.*;

public class TopologicalSort {
    /*
     * Not a sorting technique
     */

    // Khan's Algorithm if bfs is mentioned
    // If dfs is mentioned use stack

    static void sort(List<List<Integer>> adjacent, int v) {
        int[] arr = new int[v];
        for (int i = 0; i < v; i++)
            for (int a : adjacent.get(i))
                arr[a]++;

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < v; i++)
            if (arr[i] == 0)
                q.add(i);

        int c = 0;
        while (!q.isEmpty()) {
            int val = q.poll();
            System.out.print(val + " ");
            c++;
            for (int a : adjacent.get(val)) {
                if (--arr[a] == 0)
                    q.add(0);
            }
        }

        if (c != v)
            System.out.println("Cycle");
    }
}
