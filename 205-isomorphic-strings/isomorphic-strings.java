class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> iso = new HashMap();
        Map<Character,Character> iso1 = new HashMap();

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(iso.containsKey(c1)) {
                if(iso.get(c1) != c2) return false;
            } else if (iso1.containsKey(c2)) {
                return false;
            } else {
                iso1.put(c2,c1);
                iso.put(c1,c2);
            }
        }

        return true;
    }
}