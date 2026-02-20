import java.util.*;
import java.util.LinkedList;

/*
Types of views in trees
    Left view - each level 1st node
    Right view - each level last node
    Horizontal view - all nodes in level order
    Vertical view - based on hd view left to right all values
    Top view - hD 1st
    Bottom view - hd last

*/
class Pair {
    Node node;
    int hd;

    public Pair(Node node, int hd) {
        this.hd = hd;
        this.node = node;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        this.data = val;
    }
}

public class ViewsInTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Node root = buildTree(input);
        sc.close();
    }

    static Node buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null"))
            return null;
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node temp = q.poll();
            if (!values[i].equals("N")) {
                temp.left = new Node(Integer.parseInt(values[i]));
                q.add(temp.left);
            }
            i++;
            if (i >= values.length)
                break;
            if (!values[i].equals("N")) {
                temp.right = new Node(Integer.parseInt(values[i]));
                q.add(temp.right);
            }
            i++;
        }
        return root;
    }

    static List<Integer> horizontalView(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        return res;
    }

    static List<Integer> topview(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair temp = q.poll();

            /*
             * This is for vertical view
             * Create an array list and add all values here
             * map.putIfAbsent(temp.hd,new ArrayList<>());
             * map.get(temp.hd).add(temp.node.data);
             * 
             * remove the first if condition for vertical view aswell
             * 
             */

            /*
             * Removing line 66 and 67 Makes it vertical view;
             */
            if (!map.containsKey(temp.hd)) // Excluding this condition makes it bottom view
                map.put(temp.hd, temp.node.data);
            if (temp.node.left != null)
                q.add(new Pair(temp.node.left, temp.hd - 1));
            if (temp.node.right != null)
                q.add(new Pair(temp.node.right, temp.hd + 1));
        }
        return res;
    }
}
