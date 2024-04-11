/*
Logic:
Time Complexity: O(nlogn)
Space Complexity: O(logn) -> sort
Keep two pointers
*/



class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
       Arrays.sort(tokens);
       int start = 0, end = tokens.length - 1;
       int maxScore = 0;
       int currScore = 0;
       while(start <= end) {
            boolean FU1 = (power >= tokens[start]);
            boolean FD1 = (currScore >= 1);
            
            if(FU1) {
                currScore += 1;
                power -= tokens[start];
                start++;
            } else if(FD1 && start != end) {
                currScore -= 1;
                power += tokens[end];
                end--;
            }  else {
                break;
            }
            maxScore = Math.max(maxScore,currScore);
       }
       return maxScore;
    }
}