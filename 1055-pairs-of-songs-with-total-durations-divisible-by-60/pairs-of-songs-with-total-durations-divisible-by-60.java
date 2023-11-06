class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> res = new HashMap();
        for(int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
        }
        int count = 0;
        for(int i = 0; i < time.length; i++) {
            int r = time[i];
            if(r == 0) {
                count += res.getOrDefault(0,0);
            }else if(res.containsKey(60 - r)){
                count += res.get(60 - r);
            }
            res.put(r,res.getOrDefault(r,0) + 1);
        }
        return count;
    }
}