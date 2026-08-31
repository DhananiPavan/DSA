class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCritical = -1;

        int min = Integer.MAX_VALUE;
        int max = 0;

        int index = 1;

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null && cur.next != null) {

            if ((cur.val < prev.val && cur.val < cur.next.val) ||
                (cur.val > prev.val && cur.val > cur.next.val)) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // From second critical point onward
                if (prevCritical != -1) {
                    min = Math.min(min, index - prevCritical);
                }

                prevCritical = index;
            }

            prev = cur;
            cur = cur.next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || prevCritical == first) {
            return new int[] { -1, -1 };
        }

        // Maximum distance = last critical - first critical
        max = prevCritical - first;

        return new int[] { min, max };
    }
}