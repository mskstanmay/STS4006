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

    public static Node buildTree(List<Integer> values) {
        if (values == null || values.isEmpty() || values.get(0) == null) {
            return null;
        }

        Node root = new Node(values.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.size()) {
            Node current = queue.poll();

            Integer leftVal = values.get(i++);
            if (leftVal != null) {
                current.left = new Node(leftVal);
                queue.offer(current.left);
            }

            if (i < values.size()) {
                Integer rightVal = values.get(i++);
                if (rightVal != null) {
                    current.right = new Node(rightVal);
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    // MAIN
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter level-order traversal values separated by spaces (-1 for null):");
        String[] input = scanner.nextLine().trim().split("\\s+");

        List<Integer> values = new ArrayList<>();
        for (String token : input) {
            if (token.equals("-1")) {
                values.add(null);
            } else {
                values.add(Integer.parseInt(token));
            }
        }

        Node root = buildTree(values);

        if (root == null) {
            System.out.println("Tree is empty or invalid input.");
            scanner.close();
            return;
        }

        List<Integer> ans = boundaryTraversal(root);
        System.out.println(ans);
        scanner.close();
    }
}