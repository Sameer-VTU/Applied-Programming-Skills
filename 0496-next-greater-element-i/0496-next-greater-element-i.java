import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store: element -> its next greater element
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Process nums2 to find all next greater elements
        for (int num : nums2) {
            // While stack is not empty and current num is greater than the top
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Prepare the result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If it's not in the map, there was no greater element
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}