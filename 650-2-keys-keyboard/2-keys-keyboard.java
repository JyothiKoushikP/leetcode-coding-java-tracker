class Solution {
    public int minSteps(int n) {
        // we start with the goal to reach n characters and we start with 1 character
        return recurse(n, 1);
    }
    
    private int recurse(int n, int len) {
        // base case: if the goal has been reached no new operations need to be used, so return 0
        if (len == n)
            return 0;
        
        // since we want the minimum answer among all candidates, 
        // the result is initially set to the maximum value.
        int res = Integer.MAX_VALUE;
        
        // extra is the len of the copied string, 
        // nPastes is the number of paste operations performed after the initial copy.
        int extra = len, nPastes = 0;
        
        // repeat while we can successfully paste the text
        while (len + extra <= n) {
            // paste the text
            len += extra;
            nPastes++;
            
            // find answer for the remaining length
            int remain = recurse(n, len);
            
            // if answer is found, update the current result
            if (remain != -1)
                res = Math.min(res, nPastes + remain);
        }
        
        // if answer is not found, return -1,
        // else return result + 1 (plus one to consider the copy operation we performed initially)
        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }
}