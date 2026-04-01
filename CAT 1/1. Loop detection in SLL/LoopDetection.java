/*
*   Code Note: 
*   In class we have simply returned a boolean value if a loop is found or not.
*   In this version we have also returned the value of the node where the loop is found.
*/
import java.util.Scanner;

class SLNode {

    int data;
    SLNode next;

    public SLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LoopDetection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLNode head = null;
        SLNode tail = null;

        for (int i = 0; i < n; i++) {
            SLNode newNode = new SLNode(sc.nextInt());
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int join = sc.nextInt();
        if (join > 0) {
            SLNode current = head;
            for (int i = 0; i < join && current != null; i++) {
                current = current.next;
            }

            if (current != null) {
                tail.next = current;
            }
        }

        System.out.println(hasLoops(head) != -1 ? "Loop found and pointers met at SLNode : " + hasLoops(head) : "No loops present");
        sc.close();
    }

    public static int hasLoops(SLNode head) {
        SLNode slow = head;
        SLNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return fast.data;
            }

        }

        return -1;
    }
}
