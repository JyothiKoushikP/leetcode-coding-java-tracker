class Solution {
    public int integerBreak(int n) {
        int result = Integer.MIN_VALUE;
        int i = 1;

        while(i <= n){
            int div = n/i;
            int rem = n%i;
            if(div >= 2 && rem == 0){
                int product = (int)(Math.pow(i,div));
                result = Math.max(result,product);
            } else if (div + rem >= 2){
                int product1 = (int)(Math.pow(i,div-1)) * (i + rem);
                int product2 = (int)(Math.pow(i,div)) * (rem);
                if(div-1 != 0){
                    result = Math.max(Math.max(product1,product2),result);
                } else {
                    result = Math.max(product2,result);
                }
            }
            i++;
        }

        return result;
    }
}