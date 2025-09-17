class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Max heap (largest element on top)
        PriorityQueue<Integer> data = new PriorityQueue<>(Collections.reverseOrder());

        // Add all numbers into heap
        for (int a : nums) {
            data.add(a);
        }

        // Poll k times to reach kth largest
        int result = 0;
        while (k > 0) {
            result = data.poll();  // remove and get the largest
            k--;
        }

        return result;
    }
}