class Solution {
    public boolean isHappy(int n) {
        HashSet<Long> res = new HashSet();
        boolean isHappy = false;
        long num = n;
        res.add(num);
        while(!isHappy) {
            long r = getHappyNumber(num);
            if(r == 1L) {
                isHappy = true;
            } else {
                if(res.contains(r)) break;
                res.add(r);
                num = r;
            }
        }

        return isHappy;
    }

    public long getHappyNumber(long n) {
        long result = 0L;
        while(n > 0) {
            long rem = n % 10;
            result += Math.pow(rem,2);
            n /= 10;
        }
        return result;
    }

}