class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indicies = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            indicies.put(nums[i], i);
        }

        for (int i=0;i<nums.length;i++) {
            int valueToFind = target - nums[i];

            if (indicies.containsKey(valueToFind) && indicies.get(valueToFind)!=i) {
                return new int[]{i, indicies.get(valueToFind)};
            }
        }

        return new int[]{};
    }
}
