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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            in.put(postorder[i], i);
        }
        TreeNode cur = construct(postorder, 0, postorder.length - 1, preorder, 0, preorder.length - 1);
        return cur;
    }
    public TreeNode construct(int[] post, int pstart, int pend, int[] pre, int prestart, int preend) {
      if( prestart>preend){
        return null;
      }
      TreeNode root= new TreeNode(pre[prestart]);
      if (prestart == preend) {
            return root;
        }
      int indroot=in.get(pre[prestart+1]);
      int numleft=indroot-pstart+1;
      root.left=construct(post,pstart,indroot,pre,prestart+1,prestart+numleft);
      root.right=construct(post,indroot+1,pend-1,pre,prestart + numleft + 1,preend);
      return root;

    }
}