package leetcode.arrays;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestInBST_230 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        AtomicInteger i = new AtomicInteger(0);

        System.out.println("Result : " + kthSmallest(root, i, 2));
    }

    public static int kthSmallest(TreeNode root, AtomicInteger i, int k) {
        if (root == null)
            return -1;
        int left = kthSmallest(root.left, i, k);
        if (left != -1)
            return left;
        if (i.incrementAndGet() == k)
            return root.val;
        return kthSmallest(root.right, i, k);
    }
}

