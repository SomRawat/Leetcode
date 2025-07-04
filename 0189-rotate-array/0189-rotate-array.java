class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case k >= n

        // Reverse 0 to k-1
        reverse(nums, 0, n-k - 1);

        // Reverse k to nums.length
        reverse(nums,n- k, n - 1);

       // Reverse the whole array
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}