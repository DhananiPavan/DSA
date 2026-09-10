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
    int count = 0;

    class Value {
        int num;

        int sum;

        Value(int num, int sum) {
            this.num = num;

            this.sum = sum;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    public Value dfs(TreeNode root) {
        if (root == null) {
            return new Value(0, 0);
        }
        Value val1 = dfs(root.left);
        Value val2 = dfs(root.right);
        int countcur = val1.num + val2.num + 1;
        int sum = val1.sum + val2.sum + root.val;
        if (sum / countcur == root.val) {
            count++;
        }
        return new Value(countcur, sum);
    }
}