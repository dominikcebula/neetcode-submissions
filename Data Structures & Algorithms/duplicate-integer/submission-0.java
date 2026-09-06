class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (seenNumbers.contains(num))
                return true;
            seenNumbers.add(num);
        }

        return false;
    }
}
