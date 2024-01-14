class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getHappyNumber(slow);
            fast = getHappyNumber(getHappyNumber(fast));
        } while (slow != fast);

        if(slow == 1) {
            return true;
        }
        return false;
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