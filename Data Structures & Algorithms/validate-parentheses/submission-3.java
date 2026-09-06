class Solution {
    private static final Map<Character, Character> CLOSE_TO_OPEN = new HashMap<>() {
        {
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }
    };

    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (!CLOSE_TO_OPEN.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char topCh = stack.pop();

                if (topCh != CLOSE_TO_OPEN.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
