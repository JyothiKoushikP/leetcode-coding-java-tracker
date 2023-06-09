class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> res = new HashMap<Integer,Integer>();
        int max = 0,start = 0;
        for(int i = 0;i<fruits.length;i++){      
                res.put(fruits[i],res.getOrDefault(fruits[i],0)+1); 
                while(res.size() > 2){
                    if(res.get(fruits[start]) == 1){
                        res.remove(fruits[start]);
                    } else {
                        res.put(fruits[start],res.get(fruits[start])-1);
                    }
                        start++;
                }
                int length = (i-start)+1 ;
                max = max > length ? max : length;
            }
        return max;
    }
}