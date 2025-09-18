class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currentTank += diff;

            // If we cannot move to the next station
            if (currentTank < 0) {
                startIndex = i + 1; // set next station as new start
                currentTank = 0;   // reset current balance
            }
        }

        // If total fuel is enough to cover total cost
        return totalTank >= 0 ? startIndex : -1;
    }
}