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
    public int pairSum(ListNode head) {
    
      ListNode slow=head;
      ListNode fst=head;
      ListNode left=head;
      while(fst!=null){
          slow=slow.next;
          fst=fst.next.next;
      }   
      //reverse
     ListNode right=reverse(slow);
      int max=0;
      while(right!=null){
        max=Math.max(right.val+left.val,max);
        right=right.next;
        left=left.next;
      }
      return max;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode next=null;
        ListNode cur=head;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}