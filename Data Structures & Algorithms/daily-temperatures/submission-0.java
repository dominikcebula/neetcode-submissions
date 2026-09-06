class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<DailyTemperature> dailyTemperatures = new Stack<>();

        for (int i=0;i<temperatures.length;i++) {
            int currentTemp = temperatures[i];

            while (!dailyTemperatures.isEmpty() && currentTemp > dailyTemperatures.peek().temp) {
                DailyTemperature topTemperature = dailyTemperatures.pop();
                result[topTemperature.index] = i - topTemperature.index;
            }

            dailyTemperatures.push(new DailyTemperature(i, currentTemp));
        }

        return result;
    }

    private record DailyTemperature(int index, int temp) {
    }
}
