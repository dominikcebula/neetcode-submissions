class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> numsSet = new TreeSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : numsSet) {
            mp.put(num, 0);
        }

        for (int num : numsSet) {
            mp.put(
                num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
        }

        return mp.values().stream().mapToInt(v -> v).max().orElse(0);
    }
}
