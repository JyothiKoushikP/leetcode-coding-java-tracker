class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        return calculateSteps(num,count);
    }

    public int calculateSteps(int num, int count) {
        if(num == 0) { 
            return count;
        }
        if(num % 2 == 0) {
            return calculateSteps(num/2,count+1);
        }
        return calculateSteps(num-1,count+1);
    }
}