class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return solve(0, nums, memo);
    }

    private int solve(int i, int[] nums, Integer[] memo) {
        if (i >= nums.length)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int rob = nums[i] + solve(i + 2, nums, memo);
        int skip = solve(i + 1, nums, memo);
        memo[i] = Math.max(rob, skip);
        return memo[i];
    }
}