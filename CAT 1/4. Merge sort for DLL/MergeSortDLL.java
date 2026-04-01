class DLLNode {
    int data;
    DLLNode prev, next;

    DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class MergeSortDLL {

    // Main merge sort function
    public static DLLNode mergeSort(DLLNode head) {
        if (head == null || head.next == null)
            return head;

        DLLNode middle = getMiddle(head);
        DLLNode nextOfMiddle = middle.next;

        // Split the list into two halves
        middle.next = null;
        if (nextOfMiddle != null)
            nextOfMiddle.prev = null;

        DLLNode left = mergeSort(head);
        DLLNode right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    // Function to find middle using slow-fast pointer
    private static DLLNode getMiddle(DLLNode head) {
        DLLNode slow = head;
        DLLNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted doubly linked lists
    private static DLLNode merge(DLLNode first, DLLNode second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.data <= second.data) {
            first.next = merge(first.next, second);
            if (first.next != null)
                first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null)
                second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}
