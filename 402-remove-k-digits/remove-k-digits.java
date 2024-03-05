class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) {
            return "0";
        }
        int count = 0;
        Stack<Integer> track = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            int x = Character.getNumericValue(num.charAt(i));
            if(track.isEmpty() || track.peek() <= x) {
                track.push(x);
            } else {
                while(!track.isEmpty() && count < k && track.peek() > x) {
                    track.pop();
                    count++;
                }
                track.push(x);
            }
        }
        while(!track.isEmpty() && count < k) {
            track.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while(!track.isEmpty()) {
            sb.insert(0,String.valueOf(track.pop()));
        }
        while(sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}