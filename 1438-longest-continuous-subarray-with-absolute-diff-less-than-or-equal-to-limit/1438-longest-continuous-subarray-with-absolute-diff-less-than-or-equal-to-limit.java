import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain maxDeque (decreasing)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Maintain minDeque (increasing)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // If the current window violates the limit, shrink from the left
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}