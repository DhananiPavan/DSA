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

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> used = new HashSet<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        Set<Integer> leaves = new HashSet<>();

        // Store all roots and collect leaf values
        for (TreeNode root : trees) {
            map.put(root.val, root);

            if (root.left != null)
                leaves.add(root.left.val);

            if (root.right != null)
                leaves.add(root.right.val);
        }

        // Find the final root
        TreeNode root = null;
        for (TreeNode node : trees) {
            if (!leaves.contains(node.val)) {
                root = node;
                break;
            }
        }

        if (root == null)
            return null;

        // Mark root as used
        used.add(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        // Every tree must be merged
        if (used.size() != trees.size())
            return null;

        return root;
    }

    private boolean dfs(TreeNode node, long min, long max) {

        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        // Merge if current node is a leaf and another tree starts here
        if (node.left == null && node.right == null) {

            TreeNode merge = map.get(node.val);

            if (merge != null && merge != node) {

                if (!used.add(merge.val))
                    return false;

                node.left = merge.left;
                node.right = merge.right;
            }
        }

        return dfs(node.left, min, node.val) &&
               dfs(node.right, node.val, max);
    }
}