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
   
    public int maxDepth(TreeNode root) {
       
      return height(root);
 
    }
    private int height(TreeNode node) {
     if(node==null){
        return 0;
     }
     int l =height(node.left);
     int r= height(node.right);
     return 1+Math.max(l,r);
        
    }
}