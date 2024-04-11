/*
Logic:
Time Complexity: O(nlogn)
Space Complexity: O(logn) -> sort
Keep two pointers
start and end
only condition is Face-up and Face-down
If Face-Up condition satisfies for start, add the score and increment the pointer
else if face-down condition satisfies, add the token score from end (Maxium token weight) and decrement
if none of the above two satisfies, just return the score
*/



class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
       Arrays.sort(tokens);
       int start = 0, end = tokens.length - 1;
       int maxScore = 0;
       int currScore = 0;
       while(start <= end) {
            if(power >= tokens[start]) {
                currScore += 1;
                power -= tokens[start];
                start++;
            } else if(currScore >= 1 && start != end) {
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