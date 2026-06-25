class Solution {
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;

            slow.next = prev;

            prev = slow;

            slow = next;
        }

        // compute twin sum
        int max = 0;

        while (prev != null) {

            max = Math.max(
                max,
                head.val + prev.val
            );

            head = head.next;
            prev = prev.next;
        }

        return max;
    }
}