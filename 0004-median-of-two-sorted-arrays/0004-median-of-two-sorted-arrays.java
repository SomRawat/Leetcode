class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Handle null cases

        if (nums1 == null || nums1.length == 0) {

            return medianOfSingleArray(nums2);

        }

        if (nums2 == null || nums2.length == 0) {

            return medianOfSingleArray(nums1);

        }

        // Ensure binary search on smaller array

        if (nums1.length > nums2.length) {

            return findMedianSortedArrays(nums2, nums1);

        }

        int len1 = nums1.length;

        int len2 = nums2.length;

        int left = 0;

        int right = len1;

        while (left <= right) {

            int partition1 = left + (right - left) / 2;

            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];

            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {

                // Even length

                if ((len1 + len2) % 2 == 0) {

                    return (Math.max(maxLeft1, maxLeft2) +

                            Math.min(minRight1, minRight2)) / 2.0;

                }

                // Odd length

                return Math.max(maxLeft1, maxLeft2);

            }

            else if (maxLeft1 > minRight2) {

                right = partition1 - 1;

            } else {

                left = partition1 + 1;

            }

        }

        // fallback (should not reach here if inputs are valid sorted arrays)

        return 0.0;

    }

    // Helper for single array median

    private static double medianOfSingleArray(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0.0;

        int n = nums.length;

        if (n % 2 == 0) {

            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;

        } else {

            return nums[n / 2];

        }

    }
}