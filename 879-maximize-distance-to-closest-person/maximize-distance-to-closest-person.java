class Solution {
    public int maxDistToClosest(int[] seats) {
        int distance = 0;
        boolean didStrike1 = false;
        int[] leftToRight = new int[seats.length];
        int[] rightToLeft = new int[seats.length];

        for(int i = 0;i < seats.length; i++) {
            if(seats[i] == 1){
                didStrike1 = true;
                distance = 0;
                leftToRight[i] = 1;
            } else if(didStrike1){
                leftToRight[i] = ++distance;
            } else {
                leftToRight[i] = 0;
            }
        }

        didStrike1 = false;
        distance = 0;
        for(int i = seats.length-1;i >= 0; i--) {
            if(seats[i] == 1){
                didStrike1 = true;
                distance = 0;
                rightToLeft[i] = 1;
            } else if(didStrike1) {
                rightToLeft[i] = ++distance;
            } else {
                rightToLeft[i] = 0;
            }
        }

        int maxDistance = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] != 1) {
                if((leftToRight[i] == rightToLeft[i])) {
                    maxDistance = Math.max(maxDistance,leftToRight[i]);
                } else if(rightToLeft[i] != 0 && leftToRight[i] == 0){
                    maxDistance = Math.max(maxDistance,rightToLeft[i]);
                } else if(rightToLeft[i] == 0 && leftToRight[i] != 0){
                    maxDistance = Math.max(maxDistance,leftToRight[i]);
                } else {
                    int min = Math.min(leftToRight[i],rightToLeft[i]);
                    maxDistance = Math.max(maxDistance,min);
                }
            }
        }

        return maxDistance;
    }
}