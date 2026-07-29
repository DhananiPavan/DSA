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
     Map<Integer, Integer> in = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        TreeNode cur = construct(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        return cur;
    }
     public TreeNode construct(int[] post, int pstart, int pend, int[] inorder, int istart, int iend) {
      if(pstart>pend || istart>iend){
        return null;
      }
      TreeNode root= new TreeNode(post[pend]);
      int indroot=in.get(post[pend]);
      int numleft=indroot-istart;
      root.left=construct(post,pstart,pstart+numleft-1,inorder,istart,indroot-1);
      root.right=construct(post,pstart+numleft,pend-1,inorder,indroot+1,iend);
      return root;

    }
}