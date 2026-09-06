class Solution {
public:
    bool isValid(string input) {
        char stack[1000];
        short top = 0;

        for (char ch : input) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[top++] = ch;
            } else {
                if (top == 0) {
                    return false;
                }

                char open = stack[--top];

                if ((ch == ')' && open != '(') ||
                    (ch == ']' && open != '[') ||
                    (ch == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return top == 0;
    }
};