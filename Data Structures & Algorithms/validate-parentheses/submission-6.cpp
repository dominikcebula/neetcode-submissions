class Solution {
private:
    const std::unordered_map<char, char> CLOSE_TO_OPEN = {
        {')', '('},
        {']', '['},
        {'}', '{'}
    };

public:
    bool isValid(string input) {
        std::stack<char> stack;

        for (char ch : input) {
            if (CLOSE_TO_OPEN.find(ch) == CLOSE_TO_OPEN.end()) {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char topCh = stack.top();
                stack.pop();

                if (topCh != CLOSE_TO_OPEN.at(ch)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
};