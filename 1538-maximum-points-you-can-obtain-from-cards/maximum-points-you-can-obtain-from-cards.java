class Solution {
        public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int maxPoints = 0;
        
        // Calculate the initial sum of the last k elements
        for (int i = n - k; i < n; i++) {
            maxPoints += nums[i];
        }

        int currentWindow = maxPoints;

        // Starting from the last window (the last k elements)
        // Move the window to the left and calculate the maximum score
        int pointer = 0;
        for (int i = n - k; i < n; i++) {
            currentWindow = currentWindow - nums[i] + nums[pointer++];
            maxPoints = Math.max(maxPoints, currentWindow);
        }

        return maxPoints;
    }

}