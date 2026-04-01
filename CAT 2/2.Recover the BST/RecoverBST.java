import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class RecoverBST {
    Node wrongNode1 = null;
    Node wrongNode2 = null;
    Node prevNode = new Node(Integer.MIN_VALUE);

    public void recoverTree(Node root) {
        inorder(root);

        // Swap the values of the two incorrectly placed nodes
        int temp = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = temp;
    }

    private void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);

        // Check for incorrectly placed nodes
        if (wrongNode1 == null && prevNode.val >= node.val) {
            wrongNode1 = prevNode;
        }
        if (wrongNode1 != null && prevNode.val >= node.val) {
            wrongNode2 = node;
        }
        prevNode = node;

        
        inorder(node.right);
    }

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

        RecoverBST solution = new RecoverBST();
        solution.recoverTree(root);

        System.out.println("Inorder Traversal of Recovered BST:");
        printInorder(root);
        System.out.println();
        scanner.close();
    }

    private static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
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
}