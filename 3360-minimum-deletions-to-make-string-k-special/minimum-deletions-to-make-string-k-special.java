

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char c: word.toCharArray()) {
            freq[c - 'a']++;
        }
        List<Integer> res = new ArrayList();
        int size = 0;
        for(int i: freq) {
           if(i != 0) size++;
        }
        int[] track = new int[size];
        int pointer = 0;
        for(int i: freq) {
            if(i != 0) {
                track[pointer++] = i;
            }
        }
        Arrays.sort(track);
        return calculate(track,0,track.length - 1,k);
    }

    public int calculate(int[] track, int start, int end, int k) {
        if(start >= end || track[end] - track[start] <= k) {
            return 0;
        }
        int step1 = track[start] + calculate(track,start + 1,end,k);
        int step2 = (track[end] - track[start] - k) + calculate(track,start,end-1,k);

        return Math.min(step1,step2);
    }
}