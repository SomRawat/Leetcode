class Solution {
   public static int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort by start
        
        // store end days basically ma min heap bana raha hu jispa uss din ka event honga this will help me to know which event is finishing fast at that day
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 

        int day = 0, i = 0, n = events.length, count = 0;

        while (i < n || !minHeap.isEmpty()) {

            if (minHeap.isEmpty()) {

                day = events[i][0]; // jump to next event start

            }

            // add all events starting today

            while (i < n && events[i][0] == day) {

                minHeap.offer(events[i][1]);

                i++;

            }

            // remove expired events

            while (!minHeap.isEmpty() && minHeap.peek() < day) {

                minHeap.poll();

            }

            // attend one event (earliest ending)

            if (!minHeap.isEmpty()) {

                minHeap.poll();

                count++;

                day++;

            }

        }

        return count;

    }
}