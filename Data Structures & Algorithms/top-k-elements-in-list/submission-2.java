class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();

        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<NumFreq> heap = new PriorityQueue<>(new NumFreqComparator());
        for (Map.Entry<Integer, Integer> numFreq : numToFreq.entrySet()) {
            heap.offer(new NumFreq(numFreq.getKey(), numFreq.getValue()));
        }

        int[] response = new int[k];

        for (int i=0;i<k;i++) {
            response[i] = heap.poll().num;
        }

        return response;
    }

    private record NumFreq(int num, int freq) {}

    private class NumFreqComparator implements Comparator<NumFreq> {
        public int compare(NumFreq a, NumFreq b) {
            return b.freq - a.freq;
        }
    }
}
