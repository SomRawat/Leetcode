class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> events = new TreeMap<>();

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            events.put(start, events.getOrDefault(start, 0) + passengers);
            events.put(end,   events.getOrDefault(end, 0) - passengers);
        }

        int currentPassengers = 0;

        for (int change : events.values()) {
            currentPassengers += change;
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}