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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        TreeNode cur = construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return cur;
    }

    public TreeNode construct(int[] pre, int pstart, int pend, int[] inorder, int istart, int iend) {
      if(pstart>pend || istart>iend){
        return null;
      }
      TreeNode root= new TreeNode(pre[pstart]);
      int indroot=in.get(pre[pstart]);
      int numleft=indroot-istart;
      root.left=construct(pre,pstart+1,pstart+numleft,inorder,istart,indroot-1);
      root.right=construct(pre,pstart+numleft+1,pend,inorder,indroot+1,iend);
      return root;

    }
}