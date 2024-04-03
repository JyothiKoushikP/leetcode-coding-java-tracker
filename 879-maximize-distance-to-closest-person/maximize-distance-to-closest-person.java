class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int left = -1, right = 0;
        int max = 0;
        for(int i=0;i<n;i++) {
            if(seats[i] == 1){
                left = i;
            } else {
                while(right < n && (seats[right] == 0 || right < i)){
                    right++;
                }
                int distanceFromLeft = (left == -1) ? n : i-left;
                int distanceFromRight = (right == n) ? n : right-i;
                max = Math.max(max,Math.min(distanceFromLeft,distanceFromRight));
            }
        }
        return max;
    }

}