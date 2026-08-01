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
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // Find the leftmost node in the right subtree
            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }

            // Attach the left subtree to the leftmost node's left child
            curr.left = root.left;

            return root.right;
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else {
            root.right = delete(root.right, key);
        }

        return root;
    }
}