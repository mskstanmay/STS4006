/*
*   Code Note: 
*   In class we have simply returned a boolean value if a loop is found or not.
*   In this version we have also returned the value of the node where the loop is found.
*/
import java.util.Scanner;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LoopDetection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int join = sc.nextInt();
        if (join > 0) {
            Node current = head;
            for (int i = 0; i < join && current != null; i++) {
                current = current.next;
            }

            if (current != null) {
                tail.next = current;
            }
        }

        System.out.println(hasLoops(head) != -1 ? "Loop found and pointers met at Node : " + hasLoops(head) : "No loops present");
        sc.close();
    }

    public static int hasLoops(Node head) {
        Node slow = head;
        Node fast = head;

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
