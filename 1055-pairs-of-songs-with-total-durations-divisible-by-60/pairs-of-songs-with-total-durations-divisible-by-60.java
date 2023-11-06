class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        for(int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
        }
        int count = 0;
        for(int i = 0; i < time.length; i++) {
            int r = time[i];
            if(r == 0) {
                count += rem[0];
            }else {
                count += rem[60-r];
            }
            rem[r]++;
        }
        return count;
    }
}