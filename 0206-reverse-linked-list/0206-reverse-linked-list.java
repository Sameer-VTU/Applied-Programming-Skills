class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            // 1. Save the next node
            ListNode nextTemp = curr.next;
            
            // 2. Flip the pointer (the "reverse" step)
            curr.next = prev;
            
            // 3. Move pointers forward
            prev = curr;
            curr = nextTemp;
        }
        
        // At the end, prev will be the new head
        return prev;
    }
}