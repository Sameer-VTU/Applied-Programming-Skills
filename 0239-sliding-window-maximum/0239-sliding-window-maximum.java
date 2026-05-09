import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        
        int[] result = new int[n - k + 1];
        // Deque will store indices
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window bound
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Remove indices of elements smaller than the current element
            // because they will never be the maximum in this or future windows
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add current element's index
            deque.offerLast(i);
            
            // 4. If window has reached size k, the front is the maximum
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}