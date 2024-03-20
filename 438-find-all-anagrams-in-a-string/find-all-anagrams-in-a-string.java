class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int k = p.length();
    Map<Character,Integer> sCount = new HashMap<>();
    Map<Character,Integer> pCount = new HashMap<>();
    int left = 0;

    for(char ch: p.toCharArray()) {
        pCount.put(ch,pCount.getOrDefault(ch,0) + 1);
    }

    for(int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        sCount.put(ch,sCount.getOrDefault(ch,0) + 1);

        if(right - left + 1 == k) {
            if(sCount.equals(pCount)){
                res.add(left);
            }
            if(sCount.get(s.charAt(left)) == 1) {
                sCount.remove(s.charAt(left));
            } else {
                sCount.put(s.charAt(left),sCount.get(s.charAt(left)) - 1);
            }
            left++;
        }
    }

    return res;
  }

}