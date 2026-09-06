class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String str : strs) {
            String sortedStr = sortedString(str);

            groupedAnagrams.putIfAbsent(sortedStr, new ArrayList<>());
            List<String> anagramGroup = groupedAnagrams.get(sortedStr);
            anagramGroup.add(str);
        }

        return new LinkedList<>(groupedAnagrams.values());
    }

    private String sortedString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
