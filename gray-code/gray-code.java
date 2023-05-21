class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        return recursiveGrayCode(result,1,n);
    }

    public List<Integer> recursiveGrayCode(List<Integer> result, int start, int end) {
        if(start > end){
            return result;
        }
        int n = result.size();
        for(int i = n-1;i >= 0;i--) {
            int ele = (result.get(i)) + n;
            result.add(ele);
        }

        return recursiveGrayCode(result,start+1,end);
    }
}