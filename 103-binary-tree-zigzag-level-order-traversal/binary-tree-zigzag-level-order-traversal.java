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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return ans;
        q.offer(root);
        int index=0;
        while(!q.isEmpty()){
        int numofnodes=q.size();
        List<Integer> subtree=new ArrayList<>();
        for(int i =0;i<numofnodes;i++){
            if(q.peek().left!=null) q.offer(q.peek().left);
            if(q.peek().right!=null) q.offer(q.peek().right);
            subtree.add(q.poll().val);
            
        }
        if(index%2==0){
            ans.add(subtree);
        }
        else{
            Collections.reverse(subtree);
            ans.add(subtree);
        }
        index++;
       }
       return ans;
    }
}