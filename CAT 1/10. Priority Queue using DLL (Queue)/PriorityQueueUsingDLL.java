import java.util.Scanner;

public class PriorityQueueUsingDLL {

    private DLNode head;

    public void insert(int data, int priority) {
        DLNode newNode = new DLNode(data, priority);
        if (head == null || head.priority < priority) {
            newNode.next = head;
            if (head != null)
                head.prev = newNode;
            head = newNode;
            return;
        }

        DLNode temp = head;
        while (temp.next != null && temp.next.priority >= priority) {
            temp.next = temp;
        }
        /*
         * Going to the place where we have to insert this based on priority
         */
        newNode.next = temp.next;
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        /*
         * Adding the next connection
         * Adding the prev connection
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueueUsingDLL pq = new PriorityQueueUsingDLL();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            pq.insert(sc.nextInt(), sc.nextInt());
        sc.close();
    }
}