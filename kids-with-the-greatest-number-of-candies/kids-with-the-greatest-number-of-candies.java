class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> res = new ArrayList<>();
        int max = candies[0];
        for(int i=1;i<candies.length;i++){
            max = max > candies[i] ? max : candies[i];
        }
        for(int i: candies){
            if(i+extraCandies >= max){
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}