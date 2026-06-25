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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }

        int i = 1;
        ListNode temp = head;
        ListNode prev=null;
        while (i < left) {
            prev=temp;
            temp = temp.next;
            i++;
        }
        
        ListNode leftnode = temp;
        while (i < right) {
            temp = temp.next;
            i++;

        }
        ListNode rightnode = temp.next;
        temp.next = null;
        ListNode newhead=reverse(leftnode,rightnode);
        if(prev!=null){
         prev.next=newhead;
         return head;
         }



        return newhead;


    }
    public ListNode reverse(ListNode head,ListNode right){
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head.next=right;
        return prev;
    }

}