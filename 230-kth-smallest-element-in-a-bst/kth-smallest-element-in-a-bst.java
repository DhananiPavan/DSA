// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         if (root == null) {
//             return -1;
//         }
//         List<Integer> ans = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();

//         q.offer(root);
//         while(!q.isEmpty()){
//          TreeNode cur =q.poll();
//          ans.add(cur.val);
//          if(cur.left!=null) q.offer(cur.left);
//          if(cur.right!=null) q.offer(cur.right);

//         }
//         Collections.sort(ans);
//         return ans.get(k-1);
//     }
// }
class Solution {
    List<Integer> arr = new ArrayList();

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        arr.add(root.val);
        traverse(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return arr.get(k - 1);
    }
}