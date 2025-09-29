class Solution {
    public int maxProduct(int[] nums) {
           int n = nums.length;
        int maxProduct = nums[0];

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            // Reset to 1 if prefix becomes zero
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[n - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
}