class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lCapacity = 0;
        int uCapacity = 0;
        int result = 0;

        for(int i : weights) {
            lCapacity = Math.max(lCapacity,i);
            uCapacity += i;
        }
        if(days == 1) {
            return uCapacity;
        }

        while(lCapacity < uCapacity) {
            int mid = lCapacity + (uCapacity - lCapacity) / 2;
            if(!canBeShipped(weights,days,mid)) {
                lCapacity = mid + 1;
            } else {
                result = mid;
                uCapacity = mid;
            }
        }

        return result;
    }

    public boolean canBeShipped(int[] weights, int days, int k) {
        int totalDays = 0, weight = 0, i = 0;
        while (i < weights.length) {
            int j = i;
            while(j < weights.length && weight <= k) {
                weight += weights[j];
                if(weight > k) {
                    i = j;
                    break;
                }
                j++;
            }
            weight = 0;
            totalDays++;
            i = (j == weights.length) ? j : i;
        }
        return totalDays <= days;
    }

}