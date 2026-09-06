class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] charCounts = new int['z' - 'a' + 1];

        for (int i=0;i<s.length();i++) {
            charCounts[s.charAt(i)-'a']++;
            charCounts[t.charAt(i)-'a']--;
        }

        for (int charCount : charCounts)
            if (charCount!=0)
                return false;

        return true;
    }
}
