class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        Set<Character> track = new HashSet<>();
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(!track.contains(c)) {
                while(!st.isEmpty() && Character.compare(st.peek(), c) > 0 && freq[st.peek() - 'a'] >= 1) {
                    char ch = st.pop();
                    track.remove(ch);
                }
                st.push(c);
                freq[c - 'a']--;
                track.add(c);
            } else {
                freq[c - 'a']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        StringBuilder rev = sb.reverse();
        return rev.toString();
    }
}