class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] newTemp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            newTemp[nums[i]] = -1;
        }

        for (int i = 0; i <= n; i++) { 
            if (newTemp[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}