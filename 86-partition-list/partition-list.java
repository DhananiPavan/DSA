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
    public ListNode partition(ListNode head, int x) {
       ListNode less=new ListNode(0);
       ListNode great =new ListNode(0);
       ListNode ls=less;
       ListNode gs=great;
       ListNode cur=head;
       while(cur!=null){
        if(cur.val<x){
            ls.next=cur;
            ls=ls.next;
        }
        else{
            gs.next=cur;
            gs=gs.next;
        }
        cur=cur.next;
       }
       gs.next=null;
       ls.next=great.next;

       return less.next;
    }
}