class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(0);
        for(int i = 1; i < temperatures.length; i++) {
            while(!temp.isEmpty() && temperatures[i] > temperatures[temp.peek()]) {
                int index = temp.pop();
                result[index] = i - index;
            }
            temp.push(i);
        }
        return result;
    }
}