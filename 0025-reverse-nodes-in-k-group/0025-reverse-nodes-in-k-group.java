class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if there are at least k nodes left
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, we reverse them
        if (count == k) {
            // Step 2: Reverse the first k nodes (standard reversal logic)
            ListNode prev = null;
            ListNode next = null;
            ListNode tempHead = head;
            for (int i = 0; i < k; i++) {
                next = tempHead.next;
                tempHead.next = prev;
                prev = tempHead;
                tempHead = next;
            }

            // Step 3: head is now the tail of the reversed group.
            // Recursively call for the rest of the list and connect.
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            // 'prev' is the new head of this reversed k-group
            return prev;
        }

        // If less than k nodes left, return head as is
        return head;
    }
}