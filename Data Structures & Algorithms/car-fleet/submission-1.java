class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        CarData[] cars = new CarData[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new CarData(position[i], speed[i]);
        }
        Arrays.sort(cars, new CarDataReverseComparator());
        Stack<Double> carFleets = new Stack<>();

        for (CarData car : cars) {
            double timeToReachTarget = (target - car.position) / (double) car.speed;
            carFleets.push(timeToReachTarget);

            if (carFleets.size() >= 2 && carFleets.peek() <= carFleets.get(carFleets.size() - 2)) {
                carFleets.pop();
            }
        }

        return carFleets.size();
    }

    private record CarData(int position, int speed) {}

    private class CarDataReverseComparator implements Comparator<CarData> {
        public int compare(CarData a, CarData b) {
            return b.position - a.position;
        }
    }
}
