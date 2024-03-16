class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> track = new Stack<Integer>();
        int p1 = 0, p2 = 0;
        while(p2 < popped.length) {
            if(!track.isEmpty() && track.peek() == popped[p2]) {
                track.pop();
                p2++;
            } else if(p1 < pushed.length) {
               while(p1 < pushed.length) {
                    track.push(pushed[p1++]);
                    if(track.peek() == popped[p2]) {
                        break;
                    }
                } 
            } else {
                break;
            }
        }
        
        return p2 == popped.length;
    }
}