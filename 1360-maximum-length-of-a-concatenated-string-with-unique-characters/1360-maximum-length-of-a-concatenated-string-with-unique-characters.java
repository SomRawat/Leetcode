import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        return solve(0, arr, "");
    }

    private int solve(int i, List<String> arr, String temp) {
        if (i >= arr.size()) {
            return temp.length();
        }

        int include = 0, exclude = 0;

        // Exclude the current string
        exclude = solve(i + 1, arr, temp);

        // Include the current string if it doesn't have duplicates
        if (!hasDuplicate(arr.get(i), temp)) {
            include = solve(i + 1, arr, temp + arr.get(i));
        }

        return Math.max(include, exclude);
    }

    private boolean hasDuplicate(String s1, String s2) {
        int[] charCount = new int[26];

        // Count characters in the first string
        for (char ch : s1.toCharArray()) {
            if (charCount[ch - 'a'] > 0) {
                return true;
            }
            charCount[ch - 'a']++;
        }

        // Check for duplicates with the second string
        for (char ch : s2.toCharArray()) {
            if (charCount[ch - 'a'] > 0) {
                return true;
            }
        }

        return false;
    }
}