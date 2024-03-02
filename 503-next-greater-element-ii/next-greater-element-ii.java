import java.lang.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> t = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!t.isEmpty() && t.peek() <= nums[i]) {
                t.pop();
            }

            if(t.isEmpty()) {
                int index = (i + 1) % n;
                while(index != i && t.isEmpty()) {
                    if(nums[index] > nums[i]) {
                        t.push(nums[index]);
                    }
                    index = (index + 1) % n;
                }
            } 

            if(t.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = t.peek();
            }
            t.push(nums[i]);
        }
        return res;
    }
}