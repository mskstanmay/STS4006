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

        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);
        RecoverBST solution = new RecoverBST();
        solution.recoverTree(root);
        // Print the corrected BST
        System.out.println("Inorder Traversal of Recovered BST:");
        printInorder(root);
    }

    private static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}