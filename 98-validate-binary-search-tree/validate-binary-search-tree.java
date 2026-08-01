class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // Check if the current node violates the range bounds
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // For the left subtree, max allowed value is node.val
        // For the right subtree, min allowed value is node.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}