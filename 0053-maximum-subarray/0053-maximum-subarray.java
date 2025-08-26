class Solution {
    public int maxSubArray(int[] nums) {
        // Handle the edge case of an empty or null array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize variables with the first element's value
        int maxSum = nums[0];
        int currentSum = nums[0];

        // Start the loop from the second element
        for (int i = 1; i < nums.length; i++) {
            // Step 1: Update currentSum (the "fresh start" principle)
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Step 2: Update maxSum if we've found a new best sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}