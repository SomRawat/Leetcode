class Solution {
   public int minAddToMakeValid(String s) {
    int left = 0;  // Unmatched '(' count
    int right = 0; // Unmatched ')' count

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            left++; 
        } else if (c == ')') {
            if (left > 0) {
                left--; 
            } else {
                right++;
            }
        }
    }

    return left + right; 
}
}