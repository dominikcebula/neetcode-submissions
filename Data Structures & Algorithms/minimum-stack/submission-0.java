class MinStack {
    private List<Integer> values = new ArrayList<>();
    private List<Integer> minValue = new ArrayList<>();
    
    public void push(int val) {
        values.add(val);
        
        if (minValue.isEmpty())
            minValue.add(val);
        else
            minValue.add(Math.min(val, minValue.getLast()));
    }
    
    public void pop() {
        values.removeLast();
        minValue.removeLast();
    }
    
    public int top() {
        return values.getLast();
    }
    
    public int getMin() {
        return minValue.getLast();
    }
}
