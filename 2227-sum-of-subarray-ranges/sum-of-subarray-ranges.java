class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[][] dpMin = new int[n][n];
        for(int i = 0; i < n; i++) {
            dpMin[i][i] = nums[i];
        }   
        for(int j = 1; j < n; j++) {
            int r = 0;
            int c = j;
            while(r < n && c < n) {
                dpMin[r][c] = Math.min(dpMin[r][c-1], dpMin[r+1][c]);
                r += 1;
                c += 1;
            }
        }

        int[][] dpMax = new int[n][n];
        for(int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
        }   
        for(int j = 1; j < n; j++) {
            int r = 0;
            int c = j;
            while(r < n && c < n) {
                dpMax[r][c] = Math.max(dpMax[r][c-1], dpMax[r+1][c]);
                r += 1;
                c += 1;
            }
        }
        long sum = 0L;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += (dpMax[i][j] - dpMin[i][j]);
            }
        }

        return sum;
    }
}