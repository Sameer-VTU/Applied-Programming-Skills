class Solution {
    public void moveZeroes(int[] nums) {
        // Edge case: if array is null or has only 1 element, no need to move
        if (nums == null || nums.length <= 1) {
            return;
        }

        int lastNonZeroFoundAt = 0;

        // Iterate through the array
        for (int cur = 0; cur < nums.length; cur++) {
            // If the current element is not 0, swap it with the last non-zero pointer
            if (nums[cur] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;
                
                lastNonZeroFoundAt++;
            }
        }
    }
}