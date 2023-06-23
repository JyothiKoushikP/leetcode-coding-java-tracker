class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> happyNumbers = new ArrayList();
        boolean isHappy = false;
        happyNumbers.add(n);
        while(!isHappy) {
            int replace = isHappyNumber(n);
            if(n == 1){
                isHappy = true;
            } else {
                if(happyNumbers.contains(replace)){
                    return false;
                }
                happyNumbers.add(replace);
                n = replace;
            }
        }
        return isHappy;
    }

    public int isHappyNumber(int n){
        int sum = 0;
        while (n != 0) {
            int rem = n%10;
            sum += Math.pow(rem,2);
            n = n/10;
        }
        return sum;
    }

}