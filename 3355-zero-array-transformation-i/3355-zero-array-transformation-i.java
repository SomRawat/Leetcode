class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        // make a difference array
        int[] difference = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            difference[l] += 1;
            if (r + 1 < difference.length)
                difference[r + 1] -= 1;
        }

        // then cumulative sum
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += difference[i];
            difference[i] = temp;
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] > difference[j])
                return false;
        }
        return true;
    }
}