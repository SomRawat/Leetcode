class Solution {
   public static String countAndSay(int n) {
        if (n == 1) return "1"; // Base case

        String result = "1"; // Starting value
        for (int i = 2; i <= n; i++) {
            result = getNextSequence(result);
        }
        return result;
    }

    private static String getNextSequence(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            // If next char is the same, increase count
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i));
                count = 1; // Reset count for next character
            }
        }
        return sb.toString();
    }
    
}