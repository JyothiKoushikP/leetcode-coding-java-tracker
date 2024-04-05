/*
Redo - recursive approach
if(org.length == n) return count;
else org + copy > n it means you cannot create a string, return IM
if org  == copy, no point in copying the same thing, so paste and continue
otherwise,get the min of copy and paste
*/


class Solution {
    public int minSteps(int n) {
        return minStepsRecursive(n,"A","",0);
    }

    public int minStepsRecursive(int n, String org, String copy, int count) {
        if(org.length() == n) {
            return count;
        }
        if(org.length() + copy.length() > n) {
            return Integer.MAX_VALUE;
        }

        int minOperations = 0;

        if(copy.isEmpty()) {
            minOperations =  minStepsRecursive(n,org,copy + org,count + 1);
        }else if(org.length() == copy.length()) {
            minOperations =  minStepsRecursive(n,org + copy,copy,count + 1);
        } else if(org.length() > copy.length()) {
            minOperations = Math.min(minStepsRecursive(n, org+copy, copy, count + 1), minStepsRecursive(n, org,org , count + 1));
        }
        return minOperations;
    }
}