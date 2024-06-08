class Solution {
    // public int hIndex(int[] citations) {
    //     Arrays.sort(citations);
    //     Map<Integer,Integer> record = new HashMap<>();
    //     int minValue = Integer.MAX_VALUE;
    //     int last = citations.length - 1;
    //     for(int i = citations.length - 1; i >= 0; i--) {
    //         minValue = Math.min(minValue, citations[i]);
    //         record.put(minValue, (last - i) + 1);
    //     }
    //     int h_index = Integer.MIN_VALUE;
    //     for(int i: record.keySet()) {
    //         int c = i, p = record.get(c);
    //         h_index = Math.max(h_index, Math.min(c,p));
    //     }
    //     return h_index;
    // }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[citations.length + 1];
        for(int i: citations) {
            papers[Math.min(i,n)] += 1;
        }
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i = papers.length - 1; i >= 0; i--) {
            sum += papers[i];
            maxValue = Math.max(maxValue, Math.min(i,sum));
        }
        return maxValue;
    }
}