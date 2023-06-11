class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        HashMap<Integer,List<Integer>> result = new HashMap();

        for(int i: arr){
            int bits = findBits(i);
            result.putIfAbsent(bits,new ArrayList());
            result.get(bits).add(i);
        }

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(result.keySet());
        Collections.sort(sortedKeys);

        int p = 0;

        int[] res = new int[n];
        for(int bits: sortedKeys) {
            List<Integer> entries = result.get(bits);
            Collections.sort(entries);
            for(int i: entries){
                res[p++] = i;
            }
        }

        return res;
    }

    public int findBits(int n){
        int count = 0;
        while(n > 0) {
            int x = n & 1;
            if(x == 1) count++;
            n >>= 1;
        }
        return count;
    }
}