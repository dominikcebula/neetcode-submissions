class Solution {
    public boolean isPalindrome(String input) {
        char[] chars = input.toLowerCase().toCharArray();

        int leftIdx = 0;
        int rightIdx = chars.length - 1;

        while (leftIdx < rightIdx) {
            while (!isAlphanum(chars[leftIdx]) && leftIdx < rightIdx) ++leftIdx;
            while (!isAlphanum(chars[rightIdx]) && leftIdx < rightIdx) --rightIdx;

            if (leftIdx >= rightIdx)
                return true;

            if (chars[leftIdx] != chars[rightIdx])
                return false;

            ++leftIdx;
            --rightIdx;
        }

        return true;
    }

    private boolean isAlphanum(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
