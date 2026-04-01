import java.util.Scanner;
import java.util.Stack;

public class CelebrityFinder {

    public static int findCelebrity(int n, int[][] arr) {
        Stack<Integer> stack = new Stack<>();

        // Push all persons into stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Eliminate non-celebrities
        while (stack.size() > 1) {
            int personA = stack.pop();
            int personB = stack.pop();

            if (arr[personA][personB] == 1) {
                // personA knows personB → personA cannot be celebrity
                stack.push(personB);
            } else {
                // personA does not know personB → personB cannot be celebrity
                stack.push(personA);
            }
        }

        // Candidate left
        int candidate = stack.pop();

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (arr[i][candidate] == 0 || arr[candidate][i] == 1) {
                    return -1; // Not a celebrity
                }
            }
        }
        return candidate; // Celebrity found
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int celebrity = findCelebrity(n, arr);
            System.out.println(celebrity);
        }
    }
}
