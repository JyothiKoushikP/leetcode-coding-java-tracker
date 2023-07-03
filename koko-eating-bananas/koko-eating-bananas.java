class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int great = piles[0],low = 1;
        double hours = h;
        for(int i: piles){
            great = great > i ? great : i;
        }
        while(low < great){
            int mid = low + (great-low)/2;
            double sum = 0;
            
            for(int pile: piles){
                sum += Math.ceil((double)pile/mid);
            }

            if(sum > hours){
                low = mid + 1;
            } else if(sum <= hours){
                great = mid;
            }
        }
    return great;
    }
}