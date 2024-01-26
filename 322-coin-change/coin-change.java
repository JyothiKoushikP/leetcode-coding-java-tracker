class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dpArray = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            dpArray[i] = Integer.MAX_VALUE;
            for(int coin: coins) {
                if(coin <= i && dpArray[i - coin] != Integer.MAX_VALUE) {
                    dpArray[i] = Math.min(dpArray[i],1 + dpArray[i-coin]);
                }
             }
        }
        return dpArray[amount] == Integer.MAX_VALUE ? -1 : dpArray[amount];
    }

    
}