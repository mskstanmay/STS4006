import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {

    // Function to perform Vertical Order Traversal
    public static List<List<Integer>> verticalOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
        Queue<SimpleEntry<Node, Integer>> queue = new LinkedList<>();

        queue.offer(new SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            SimpleEntry<Node, Integer> entry = queue.poll();

            Node node = entry.getKey();
            int col = entry.getValue();

            verticalMap
                .computeIfAbsent(col, k -> new ArrayList<>())
                .add(node.val);

            if (node.left != null) {
                queue.offer(new SimpleEntry<>(node.left, col - 1));
            }

            if (node.right != null) {
                queue.offer(new SimpleEntry<>(node.right, col + 1));
            }
        }

        for (List<Integer> values : verticalMap.values()) {
            result.add(values);
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> res = verticalOrderTraversal(root);

        // Print result
        for (List<Integer> col : res) {
            for (int val : col) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}