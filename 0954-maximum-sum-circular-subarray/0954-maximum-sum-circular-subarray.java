class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];

        for (int num : nums) {
            // Kadane for max
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // Kadane for min
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }

        // If all numbers are negative
        if (maxSum < 0) return maxSum;

        // Max of normal vs circular
        return Math.max(maxSum, totalSum - minSum);
    }
}