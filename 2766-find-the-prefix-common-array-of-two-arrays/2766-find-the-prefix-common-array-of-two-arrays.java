class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long maskA = 0L; // Bitmask for numbers seen in A
        long maskB = 0L; // Bitmask for numbers seen in B
        int[] ans = new int[A.length]; // Result array

        for (int i = 0; i < A.length; i++) {
            // Update masks
            maskA |= (1L << (A[i] - 1)); // Set bit for A[i]
            maskB |= (1L << (B[i] - 1)); // Set bit for B[i]

            // Calculate common mask
            long commonMask = maskA & maskB;

            // Count set bits in commonMask
            ans[i] = Long.bitCount(commonMask);
        }

        return ans;
    }
}