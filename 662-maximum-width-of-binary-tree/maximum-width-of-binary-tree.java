/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node;
    long num;   // Changed int -> long

    Pair(TreeNode node, long num) {
        this.node = node;
        this.num = num;

    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        Queue<Pair> q = new LinkedList<>();
        if (root == null) {
            return 0;

        }
        q.offer(new Pair(root, 1));
        while (!q.isEmpty()) {
            int size = q.size();
            long left = 0;
            long right = 0;
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                if (cur.node.left != null)
                    q.offer(new Pair(cur.node.left, cur.num * 2));
                if (cur.node.right != null)
                    q.offer(new Pair(cur.node.right, cur.num * 2 + 1));
                if (size >= 2) {
                    if (i == 0) {
                        left = cur.num;
                    }
                    if (i == size - 1) {
                        right = cur.num;
                    }
                   
                }
            }
             max = Math.max(max, (int)((right - left) + 1));

        }
        return max;

    }
}