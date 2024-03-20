class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList();
    int[] sCount = new int[26];
    int[] pCount = new int[26];
    for(char c: p.toCharArray()) {
        pCount[c-'a']++;
    }
    int left = 0, k = p.length();
    for(int right = 0; right < s.length(); right++) {
        char l = s.charAt(left);
        char r = s.charAt(right);

        sCount[r-'a']++;

        if(right - left + 1 == k) {
            if(Arrays.equals(pCount,sCount)){
                result.add(left);
            }
            sCount[l-'a']--;
            left++;
        }
    }

    return result;
  }

}