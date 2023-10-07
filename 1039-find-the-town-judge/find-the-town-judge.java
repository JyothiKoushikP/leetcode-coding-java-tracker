class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1];
        int[] trusted = new int[n+1];

        for(int[] trustInfo: trust) {
            trusts[trustInfo[0]] += 1;
            trusted[trustInfo[1]] += 1;
        }
        
        for(int i = 1; i < trusts.length;i++) {
            if(trusts[i] == 0 && trusted[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}