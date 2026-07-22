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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return ans;
        q.offer(root);
        while (!q.isEmpty()) {
            int numofnodes = q.size();
            Double sum=0.0;
            for (int i = 0; i < numofnodes; i++) {
                
                TreeNode curr = q.poll(); // Poll once
                sum += curr.val;

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);

            }
            ans.add(sum/numofnodes);
        }
        return ans;
    }
}