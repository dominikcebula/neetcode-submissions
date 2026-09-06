class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indicies = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            indicies.put(nums[i], i);
        }

        for (int i=0;i<nums.length;i++) {
            int valueToFind = target - nums[i];
            Integer valueToFindIdx = indicies.get(valueToFind);

            if (valueToFindIdx!=null && valueToFindIdx!=i) {
                return new int[]{i, valueToFindIdx};
            }
        }

        return new int[]{};
    }
}
