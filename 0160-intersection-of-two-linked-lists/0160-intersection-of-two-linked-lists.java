public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Loop until the two pointers meet
        while (a != b) {
            // If a reaches the end, redirect to headB; else move to next
            a = (a == null) ? headB : a.next;
            // If b reaches the end, redirect to headA; else move to next
            b = (b == null) ? headA : b.next;
        }

        // They either meet at the intersection node or at null
        return a;
    }
}