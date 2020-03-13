package problemSolving.tree;

import java.util.TreeMap;

public class PrintTopViewOfTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int val) {
            this.data = val;
            left = right = null;
        }
    }

    public static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        formTopView(root, 0);
        System.out.println("TreeMap : " + treeMap.toString());
    }

    public static void formTopView(Node root, int horDist) {
        if (root == null)
            return;
        if (treeMap.containsKey(horDist) == false) {
            treeMap.put(horDist, root.data);
        }
       // if (root.left != null)
            formTopView(root.left, horDist - 1);
       // if (root.right != null)
            formTopView(root.right, horDist + 1);
    }

}
