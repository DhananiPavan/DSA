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
    List<TreeNode> list = new ArrayList<>();
    TreeNode head = null;

    public void flatten(TreeNode root) {
        head = root;
        preorder(root);

        for (TreeNode cur : list) {
            head.left = null;
            head.right = cur;
            head = head.right;

        }

    }

   void  preorder(TreeNode root){
        if(root==null){
            return ;
        }
        if(head!=root){
          list.add(root);
        }
        preorder(root.left);
        preorder(root.right);
    }
}