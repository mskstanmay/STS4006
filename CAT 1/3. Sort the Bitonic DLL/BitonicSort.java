class DLLNode {
    int data;
    DLLNode prev, next;

    DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class BitonicSort {

    // Function to sort a bitonic doubly linked list
    public static DLLNode sortBitonicDLL(DLLNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: Find the peak point
        DLLNode curr = head;
        while (curr.next != null && curr.data <= curr.next.data) {
            curr = curr.next;
        }

        // Step 2: Split the list
        DLLNode second = curr.next;
        if (second != null)
            second.prev = null;
        curr.next = null;

        // Step 3: Reverse the second half
        second = reverse(second);

        // Step 4: Merge two sorted DLLs
        return merge(head, second);
    }

    // Reverse a doubly linked list
    private static DLLNode reverse(DLLNode head) {
        DLLNode temp = null;
        DLLNode curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null)
            head = temp.prev;

        return head;
    }

    // Merge two sorted doubly linked lists
    private static DLLNode merge(DLLNode first, DLLNode second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.data <= second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}
