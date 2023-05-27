import java.math.BigInteger;
class Solution {
    public int climbStairs(int n) {
        BigInteger[] factorial = new BigInteger[n + 1];
        factorial[0] = BigInteger.valueOf(1);
        int len = factorial.length;
        int k = 0;
        for(int i=1;i<len;i++) {
            factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));
        }
        int sum = 0;
        int x = n;
        while(x >= 0) {
            if((n-x)%2 == 0){
              int y = (n-x)/2;
              sum += factorial[x+y].divide(factorial[x]).divide(factorial[y]).intValue();
            }
            x--;
        }

        return sum;
        }
    }