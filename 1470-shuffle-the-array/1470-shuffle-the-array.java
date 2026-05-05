class Solution {

    public int[] shuffle(int[] nums, int n) {

        int base = 1001;

        // Step 1: Encode both values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + nums[i + n] * base;
        }

        // Step 2: Decode and place correctly
        int index = 2 * n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int y = nums[i] / base;
            int x = nums[i] % base;

            nums[index--] = y;
            nums[index--] = x;
        }

        return nums;
    }
}