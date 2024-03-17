/*
TC: O(N)
SC: O(N)
Dynamic Programming
Here we store the i-2, i-1 for the pre-computation
you need to make sure that i-1 element is not zero and ith element is not zero
Handle the cases:
Fibonacci: dp[i] += dp[i-1] + dp[i-2]
*/


class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < s.length() ; i++) {
            int x = s.charAt(i) - '0';
            int y = s.charAt(i-1) - '0';
            if(x == 0) {
                if(y == 0) {
                    dp[i+1] = 0;
                } else {
                    int res = (y * 10) + x;
                    if(res >= 1 && res <= 26) {
                        dp[i+1] = dp[i-1];
                    } else {
                        dp[i+1] = 0;
                    } 
                }
            } else {
                if(y == 0) {
                    dp[i+1] = dp[i];
                } else {
                    int res = (y * 10) + x;
                    if(res >= 1 && res <= 26) {
                        dp[i+1] = dp[i] + dp[i-1];
                    } else {
                        dp[i+1] = dp[i];
                    }
                }    
            }
        }

        return dp[dp.length - 1];
    }
}