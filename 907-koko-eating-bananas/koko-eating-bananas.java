class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int highest = piles[0], low = 1;

        for(int i: piles) {
            highest = Math.max(highest,i);
        }

        while(low < highest) {
            int mid = low + (highest - low)/2;
            double sum = 0;
            
            for(int pile: piles){
                sum += Math.ceil((double)pile/mid);
            }

            if(sum <= h) {
                highest = mid;
            } else {
                low = mid + 1;
            }
        }

        return highest;
    }
}