class Solution {
public:
    bool isValid(string input) {
        char stack[1000];
        char* top = stack;

        for (char ch : input) {
            if (ch == '(' || ch == '[' || ch == '{') {
                *top++ = ch;
            } else {
                if (top == stack) {
                    return false;
                }

                char open = *--top;

                if ((ch == ')' && open != '(') ||
                    (ch == ']' && open != '[') ||
                    (ch == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return top == stack;
    }
};