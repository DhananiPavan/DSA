/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> val=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            val.add(cur.val);
            cur=cur.next;
        }
        if(val.size()<=1){
            return true;
        }
        int len=val.size();
        return solve(val,0,len-1);
    }
    public boolean solve(List<Integer> val,int l,int r){
        while(l<=r){
            if(val.get(l)!=val.get(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}