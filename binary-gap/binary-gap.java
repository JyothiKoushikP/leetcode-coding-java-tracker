class Solution {
    public int binaryGap(int n) {
        int position1 = Integer.MAX_VALUE;
        int counter = 0;
        int max = 0;
        while(n > 0){
            int x = n & 1;
            if(x == 1) {
                if(position1 == Integer.MAX_VALUE) {
                    position1 = counter;
                } else {
                    max = Math.max(max,counter - position1);
                    position1 = counter;
                }
            }
            counter++;
            n >>= 1;
        }
        return max;
    }
}