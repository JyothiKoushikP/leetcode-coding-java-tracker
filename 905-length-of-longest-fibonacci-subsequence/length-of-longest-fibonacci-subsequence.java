class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0, maxIndex = 0, arrMax = 0;
        Set<Integer> r = new HashSet<>();
        Set<Pair<Integer,Integer>> pairs = new HashSet<>();
        for(int i: arr) {
            r.add(i);
            arrMax = Math.max(arrMax,i);
        }
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] + arr[i+1] > arrMax) {
                break;
            }
            maxIndex = i;
        }
        for(int i = 0; i <= maxIndex; i++) {
            for(int j = i+1; j < arr.length; j++) {
                int x1 = arr[i], x2 = arr[j], len = 1;
                while(!pairs.contains(new Pair<>(x1,x2)) && r.contains(x1+x2)) {
                    pairs.add(new Pair<>(x1,x2));
                    int temp = x1;
                    x1 = x2;
                    x2 += temp;
                    len += 1;
                }
                maxLength = Math.max(len + 1,maxLength);
            }
        }

        return maxLength > 2 ? maxLength : 0;
    }
}