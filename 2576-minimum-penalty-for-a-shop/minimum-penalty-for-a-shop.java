/*
Prefix and Suffix Sum -> O(n) O(n)
int[] prefix = new int[customers.length() + 1];
        int[] suffix = new int[customers.length() + 1];

        int sum = 0;
        for(int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if(c == 'N') {
                sum += 1;
            }
            prefix[i+1] = sum;
        }

        sum = 0;
        for(int i = customers.length() - 1; i >= 0; i--) {
            char c = customers.charAt(i);
            if(c == 'Y') {
                sum += 1;
            }
            suffix[i] = sum;
        }

        int minStart = 0;
        int minPenalty = Integer.MAX_VALUE;

        for(int i = 0; i < suffix.length; i++) {
            if(prefix[i] + suffix[i] < minPenalty) {
                minPenalty = prefix[i] + suffix[i];
                minStart = i;
            }
        }

        return minStart;
*/


class Solution {
    public int bestClosingTime(String customers) {
        int currPenalty = 0;

        for(int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if(c == 'Y') {
                currPenalty++;
            }
        }

        int minPenalty = currPenalty, minTime = 0;
        for(int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if(c == 'Y') {
                currPenalty--;
            } else {
                currPenalty++;
            }

            if(currPenalty < minPenalty) {
                currPenalty = minPenalty;
                minTime = i + 1;
            }
        }

        return minTime;
    }
}