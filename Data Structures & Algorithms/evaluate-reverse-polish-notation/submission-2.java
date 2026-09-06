class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b + a);
                }
                case "-" -> {
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b - a);
                }
                case "*" -> {
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b * a);
                }
                case "/" -> {
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b / a);
                }
                default -> {
                    numbers.push(Integer.parseInt(token));
                }
            }
        }

        return numbers.pop();
    }
}
