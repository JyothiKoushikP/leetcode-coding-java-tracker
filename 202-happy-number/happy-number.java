class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getHappyNumber(slow);
            fast = getHappyNumber(getHappyNumber(fast));
        } while (fast != 1 && slow != fast);

        return fast == 1;
    }

    public int getHappyNumber(int n) {
        int result = 0;
        while(n > 0) {
            int rem = n % 10;
            result += Math.pow(rem,2);
            n /= 10;
        }
        return result;
    }

}