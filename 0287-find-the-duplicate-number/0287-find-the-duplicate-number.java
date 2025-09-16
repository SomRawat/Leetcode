
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (exist.contains(nums[i])) {
                return nums[i]; // found duplicate
            } else {
                exist.add(nums[i]);
            }
        }
        return -1; // in case no duplicate found
    }
}