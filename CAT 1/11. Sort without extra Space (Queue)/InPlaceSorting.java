import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InPlaceSorting {
    static void sort(Queue<Integer> q, int n) {
        for (int i = 0; i < n; i++) {
            int idx = 0;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                int c = q.poll();
                if (c < min && j < n - i) {
                    min = c;
                    idx = j;
                }
                q.add(c);
            }

            for (int j = 0; j < n; j++) {
                int c = q.poll();
                if (j != idx)
                    q.add(c);

            }
            q.add(min);

            System.out.print("Iteration " + (i + 1) + ": ");
            for (int k : q) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        for (int i : q) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            q.add(sc.nextInt());
        sort(q, n);
        sc.close();
    }
}
