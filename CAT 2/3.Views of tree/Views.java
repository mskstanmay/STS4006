import java.util.*;

public class Views {

    /*
     * Horizontal view : left to right at each level from top to bottom
     * Vertical view : top to bottom at each level from left to right (tree column
     * wise)
     * Left view: root to leftmost node at each level
     * Right view: root to rightmost node at each level
     * Top view: Bottom left most node to root to bottom right most node
     * Bottom view: nodes visible when tree is viewed from bottom
     */

    // Tree Node
    static class TreeNode {
        char val;
        TreeNode left, right;

        TreeNode(char val) {
            this.val = val;
        }
    }

    // Helper Pair (for hd)
    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // ---------------- HORIZONTAL VIEW ----------------
    public static List<Character> horizontalView(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            res.add(node.val);

            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        return res;
    }

    // ---------------- VERTICAL VIEW ----------------
    public static List<Character> verticalView(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, List<Character>> map = new TreeMap<>();
        Queue<TreeNode> nq = new LinkedList<>();
        Queue<Integer> hq = new LinkedList<>();

        nq.offer(root);
        hq.offer(0);

        while (!nq.isEmpty()) {
            TreeNode node = nq.poll();
            int hd = hq.poll();

            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                nq.offer(node.left);
                hq.offer(hd - 1);
            }
            if (node.right != null) {
                nq.offer(node.right);
                hq.offer(hd + 1);
            }
        }

        for (List<Character> list : map.values()) {
            res.addAll(list);
        }
        return res;
    }

    // ---------------- LEFT VIEW ----------------
    public static List<Character> leftView(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == 0)
                    res.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return res;
    }

    // ---------------- RIGHT VIEW ---------------- In left view change if i == 0 condition to i == size - 1
    public static List<Character> rightView(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == size - 1)
                    res.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return res;
    }

    // ---------------- TOP VIEW ----------------
    public static List<Character> topView(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, Character> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (!map.containsKey(p.hd)) {
                map.put(p.hd, p.node.val);
            }

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        for (char c : map.values())
            res.add(c);
        return res;
    }

    // ---------------- BOTTOM VIEW ----------------
    public static List<Character> bottomView(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, Character> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.put(p.hd, p.node.val); // overwrite

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        for (char c : map.values())
            res.add(c);
        return res;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        root.right.left = new TreeNode('F');
        root.right.right = new TreeNode('G');

        System.out.println("Horizontal: " + horizontalView(root));
        System.out.println("Vertical: " + verticalView(root));
        System.out.println("Left: " + leftView(root));
        System.out.println("Right: " + rightView(root));
        System.out.println("Top: " + topView(root));
        System.out.println("Bottom: " + bottomView(root));
    }
}