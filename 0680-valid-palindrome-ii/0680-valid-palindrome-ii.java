class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // If characters don't match, we get a "second chance"
            if (s.charAt(left) != s.charAt(right)) {
                // Check if it's a palindrome by skipping the left OR the right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            // If they do match, just move the pointers inward
            left++;
            right--;
        }

        // If the loop finishes, the string was already a perfect palindrome
        return true;
    }

    // Helper function to check if a substring is a regular palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}