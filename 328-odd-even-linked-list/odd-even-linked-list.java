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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        // count nodes
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // again set pointer to head
        temp = head;

        // odd and even list heads
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;

        int i = 1; // node position

        while (temp != null) {
            if (i % 2 == 1) {           // odd position
                if (oddHead == null) {
                    oddHead = oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            } else {                    // even position
                if (evenHead == null) {
                    evenHead = evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }
            }
            temp = temp.next;
            i++;
        }

        // join odd and even lists
        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }
}
