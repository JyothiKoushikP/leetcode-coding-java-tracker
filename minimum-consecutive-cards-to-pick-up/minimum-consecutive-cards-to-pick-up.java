class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> window = new HashMap<>();
        for(int end = 0;end < n; end++) {
            int ele = cards[end];
            if(window.containsKey(ele)) {
                int start = window.get(ele);
                min = Math.min(min, (end - start) + 1);
            } 
            window.put(ele,end);
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}