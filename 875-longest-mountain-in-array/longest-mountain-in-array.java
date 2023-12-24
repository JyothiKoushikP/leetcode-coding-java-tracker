class Solution {
    public int longestMountain(int[] arr) {
        int i = 0;
        int maxLen = 0;
        while(i < arr.length - 1) {
            if(arr[i] < arr[i + 1]) {
                int j = i;
                while(j < arr.length - 1 && arr[j] < arr[j+1]) {
                    j++;
                }
                boolean didTurn = false;
                while(j < arr.length - 1 && arr[j] > arr[j+1]) {
                    didTurn = true;
                    j++;
                }
                if(didTurn) {
                    maxLen = Math.max(maxLen,(j - i) + 1);
                } else {
                    maxLen = Math.max(maxLen,0);
                }
                i = j;
            } else {
                i++;
            }
        }

        return maxLen;
    }
}