
import java.util.Scanner;

class SLNode {

    int data;
    SLNode next;

    public SLNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CreateSLL {

    static void printLIST(SLNode head){
        SLNode current = head;
        while(current !=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
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
        sc.close();
        printLIST(head);
    }
}
