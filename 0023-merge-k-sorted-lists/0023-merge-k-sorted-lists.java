import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to store the head nodes of the k lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-empty list into the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            // Get the smallest node from the heap
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;

            // If this list has a next node, add it to the heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}