class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //so we will use the sliding window approach over here
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < nums.length){
            
            //mainitaing the increasing order in the minQ, due to which the front of the minQ is always the minimum element
            while(!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[end])
                minQ.pollLast();
            //adding the index of the element into the deque 
            minQ.offer(end);
            
            //mainitaing the decreasing order in the maxQ, due to which the front of the minQ is always the maximum element
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[end])
                maxQ.pollLast();
            
            maxQ.offer(end);
            
            int min = nums[minQ.peek()];
            int max = nums[maxQ.peek()];
            //if the difference is greater than the limit then we will increment the start pointer
            //also we will check in the deque if the front element in both the deque still lies in the window or not...if not present in the window after moving the start pointer then we will pop the front element from the deques accordingly
            if(max-min > limit){
                start++;
                if(start > minQ.peek()) minQ.poll();
                if(start > maxQ.peek()) maxQ.poll();
            }
            //else we will store the window size for future comparisons and increase the end pointer
            else{
                ans = Math.max(ans,end-start+1);
                end++;
            }
            
            
        }
        
        return ans;
        
    }
}