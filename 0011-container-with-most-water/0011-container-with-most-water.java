class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1; 
        int ans = 0;

        while (i < j) {
            // Calculate area
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            int area = h * w;
            ans = Math.max(ans, area);

            // Move the smaller pointer
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}