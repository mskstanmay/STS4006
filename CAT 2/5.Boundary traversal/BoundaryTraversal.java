import java.util.*;

public class BoundaryTraversal {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        if (!isLeaf(root))
            res.add(root.val);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    // Check leaf
    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // LEFT BOUNDARY
    static void addLeftBoundary(Node node, List<Integer> res) {
        Node curr = node.left;

        while (curr != null) {
            if (!isLeaf(curr))
                res.add(curr.val);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    // LEAF NODES
    static void addLeaves(Node node, List<Integer> res) {
        if (node == null)
            return;

        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    // RIGHT BOUNDARY (reverse)
    static void addRightBoundary(Node node, List<Integer> res) {
        Node curr = node.right;
        Stack<Integer> stack = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr))
                stack.push(curr.val);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    // MAIN
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> ans = boundaryTraversal(root);
        System.out.println(ans);
    }
}