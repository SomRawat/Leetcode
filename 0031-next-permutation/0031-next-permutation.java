class Solution {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the pivot from the right
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot, array is in descending order (e.g., [3,2,1])
        // Reverse the whole array and return
        if (pivot == -1) {
            reverse(nums, 0);
            return;
        }

        // Step 2: Find the successor to the pivot
        int successor = -1;
        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                successor = i;
                break;
            }
        }

        // Step 3: Swap the pivot and successor
        swap(nums, pivot, successor);

        // Step 4: Reverse the suffix (the part after the pivot)
        reverse(nums, pivot + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}