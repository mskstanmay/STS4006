import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("ConvertToTryWithResources")
class TowerOfHanoi {
    static Stack<Integer> sourceStack = new Stack<>();
    static Stack<Integer> auxillaryStack = new Stack<>();
    static Stack<Integer> destinationStack = new Stack<>();

    static void change(Stack<Integer> source, Stack<Integer> target, char a, char b) {
        int v1, v2;
        if (source.isEmpty()) {
            v1 = Integer.MIN_VALUE;
        } else {
            v1 = source.pop();
        }

        if (target.isEmpty()) {
            v2 = Integer.MIN_VALUE;
        } else {
            v2 = target.pop();
        }

        if (v1 == Integer.MIN_VALUE) {
            source.push(v2);
            System.out.println("the disk " + v2 + " is moved from " + b + " to " + a);
        } else if (v2 == Integer.MIN_VALUE) {
            target.push(v1);
            System.out.println("the disk " + v1 + " is moved from " + a + " to " + b);
        } else if (v1 < v2) {
            target.push(v2);
            target.push(v1);
            System.out.println("the disk " + v1 + " is moved from " + a + " to " + b);
        } else {
            source.push(v1);
            source.push(v2);
            System.out.println("the disk " + v2 + " is moved from " + b + " to " + a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no. of disks
        sc.close();
        for (int i = n; i > 0; i--)
            sourceStack.push(i);
        char s = 'S', a = 'A', d = 'D';
        if (n % 2 == 0) {
            char temp = a;
            a = d;
            d = temp;
        }
        int moves = (int) (Math.pow(2, n) - 1);
        for (int i = 1; i <= moves; i++) {
            switch (i % 3) {
                case 1 -> change(sourceStack, destinationStack, s, d);
                case 2 -> change(sourceStack, auxillaryStack, s, a);
                case 0 -> change(auxillaryStack, destinationStack, a, d);
            }
        }
    }
}