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


    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode end;
    public void recoverTree(TreeNode root) {
        prev=first=middle=end=null;
        inorder(root);
        if(first!=null && end!=null){
            int val= first.val;
            first.val=end.val;
            end.val=val;
        }
        else{
            int val=first.val;
            first.val=middle.val;
            middle.val=val;
        }

    }
    public void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                end=root;
            }
        }
        prev=root;
        inorder(root.right);
    }

}