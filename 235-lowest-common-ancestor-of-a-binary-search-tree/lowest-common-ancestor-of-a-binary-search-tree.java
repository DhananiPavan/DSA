/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
      return find(root,p,q);
    }
    public TreeNode find(TreeNode root,TreeNode p,TreeNode q){
        // if(root==null || root==p|| root==q){
        //     return root;
        // }
        // TreeNode left=find(root.left,p,q);
        // TreeNode right=find(root.right,p,q);
        // if(left==null){
        //     return right;
        // }
        // if(right==null){
        //     return left;
        // }
        // // if(left!=null && right!=null){
        // //     return root;
        // // }
        // return root;
        if(root==null){
            return null;
        }
       if (p.val < root.val && q.val < root.val) {
            return find(root.left, p, q);
        }
        
        else if (p.val > root.val && q.val > root.val) {
            return find(root.right, p, q);
        }
        return root;

    }
}