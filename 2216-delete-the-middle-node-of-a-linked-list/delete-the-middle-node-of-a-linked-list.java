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
    public ListNode deleteMiddle(ListNode head) {

        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fst=head;
         ListNode temp=head;
        while(fst!=null && fst.next!=null){
            temp=slow;
            slow=slow.next;
            fst=fst.next.next;
            


        }
        temp.next=temp.next.next;
        return head;
        
    }
}