class Solution {
    public int numberOfMatches(int n) {
        int ans = 0; // Total number of matches played

        while (n > 1) { // Continue until only one team remains
            if (n % 2 == 0) {
                ans += n / 2; // Add the number of matches played this round
                n = n / 2;    // Update the number of teams advancing
            } else {
                ans += (n - 1) / 2; // Add the number of matches played this round
                n = (n - 1) / 2 + 1; // Update the number of teams advancing
            }
        }

        return ans;
    }
}