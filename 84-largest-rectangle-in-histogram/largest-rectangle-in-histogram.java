class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Pair<Integer,Integer>> ms = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            int x = heights[i], count = -1;
            while(!ms.isEmpty() && ms.peek().getKey() >= x) {
                int index = ms.pop().getValue();
                count = index ;
            }
            if(count == -1) {
                left[i] = i;
                ms.push(new Pair<>(x,i));
            } else {
                left[i] = count;
                ms.push(new Pair<>(x,count));
            }
        }

        ms = new Stack<>();

        for(int i = heights.length - 1; i >= 0; i--) {
            int x = heights[i], count = -1;
            while(!ms.isEmpty() && ms.peek().getKey() >= x) {
                int index = ms.pop().getValue();
                count = index ;
            }
            if(count == -1) {
                right[i] = i;
                ms.push(new Pair<>(x,i));
            } else {
                right[i] = count;
                ms.push(new Pair<>(x,count));
            }
        }

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int totalArea = ((i - left[i]) + (right[i] - i) + 1) * heights[i];
            maxArea = Math.max(maxArea, totalArea);
        }

        return maxArea;
    }
}