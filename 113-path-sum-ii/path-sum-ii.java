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
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path= new ArrayList<>();
        sum(root,targetSum,path);
        return list;
    }
    public void sum(TreeNode root,int need,List<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==need){
                list.add(new ArrayList<>(path));
            }
        }
        else{
            sum(root.left,need-root.val,path);
            sum(root.right,need-root.val,path);
        }
        path.remove(path.size()-1);

    }
}