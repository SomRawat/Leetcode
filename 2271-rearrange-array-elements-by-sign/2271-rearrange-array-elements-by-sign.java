import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        
        // Separate positive and negative numbers
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        
        int posIndex = 0;
        int negIndex = 0;
        int n = nums.length;
        
        // Alternate filling
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = positive.get(posIndex++);
            } else {
                nums[i] = negative.get(negIndex++);
            }
        }
        
        return nums;
    }
}