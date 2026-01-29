public class minStack {
    private Node top;
    private Node minTop;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public minStack() {
        this.top = null;
        this.minTop = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;

        if (minTop == null || x <= minTop.value) {
            Node newMinNode = new Node(x);
            newMinNode.next = minTop;
            minTop = newMinNode;
        }
    }

    public void pop() {
        if (top == null) return;

        if (top.value == minTop.value) {
            minTop = minTop.next;
        }
        top = top.next;
    }

    public int top() {
        if (top == null) throw new IllegalStateException("Stack is empty");
        return top.value;
    }

    public int getMin() {
        if (minTop == null) throw new IllegalStateException("Stack is empty");
        return minTop.value;
    } 
}
