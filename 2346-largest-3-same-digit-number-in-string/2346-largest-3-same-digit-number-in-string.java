class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String finalAns = "";

        for (int i = 0; i <= n - 3; i++) {
            // Check if the current 3 characters are the same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                // Form the good integer
                String currentGoodInteger = num.substring(i, i + 3);
                // Update finalAns if the current good integer is lexicographically greater
                if (currentGoodInteger.compareTo(finalAns) > 0) {
                    finalAns = currentGoodInteger;
                }
            }
        }
        return finalAns;
    }
}