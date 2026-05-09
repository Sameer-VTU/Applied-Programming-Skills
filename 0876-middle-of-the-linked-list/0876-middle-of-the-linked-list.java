/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // While fast can move two steps forward
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow 1 step
            fast = fast.next.next;     // Move fast 2 steps
        }
        
        // When fast reaches the end, slow is at the middle
        return slow;
    }
}