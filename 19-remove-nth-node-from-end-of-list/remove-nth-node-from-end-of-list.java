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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
       if(head.next==null){
        
        return null;
       }
       int i=0;
       ListNode temp=head;
       while(temp!=null){
        temp=temp.next;
        i++;
       } 
       int j =i-n;
       if (j == 0) {
            return head.next;
        }
       temp=head;
       while((j-1)>0){
        temp=temp.next;
        j--;

       }
       
       temp.next=temp.next.next;
       return head;

    }
}