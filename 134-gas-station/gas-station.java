/*
Logic:
You cannot start at a station where gas[i] < cost[i]
if you encounter such a station, then you need to go in to the next station 
as this particular station cannot be the starting point
calculate the gain -> gas[i] - cost[i] and at any point if gain < 0
then reset the gain
*/


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0, totalGain = 0, ans = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGain += (gas[i] - cost[i]);
            currGain += (gas[i] - cost[i]);
            if(currGain < 0) {
                ans = i + 1;
                currGain = 0;
            }
        }
        return (totalGain >= 0) ? ans : -1;
    }   
}