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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode>q=new LinkedList<>();
        if (root == null)
            return false;
        q.offer(root);
        boolean ans=false;
        while(!q.isEmpty()){
            int num=q.size();
            int check=0;
            for(int i=0;i<num;i++){
               TreeNode cur=q.poll();
               if(cur.val==x || cur.val==y){
                check++;
               }
               if(check==2 && (cur.val==y||cur.val==x)){
                ans=true;
               }
               if (cur.left != null && cur.right != null) {

                    int left = cur.left.val;
                    int right = cur.right.val;

                    if ((left == x && right == y) ||
                        (left == y && right == x))
                        return false;
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);

            }
        }
        return ans;
    }
}