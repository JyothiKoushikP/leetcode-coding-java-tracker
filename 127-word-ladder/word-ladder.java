class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        Map<Integer,Set<Character>> chars = new HashMap<>();
        Set<String> visited = new HashSet<>();

        int distance = 1;
        for(String word: words) {
            for(int i = 0; i < word.length(); i++) {
                chars.putIfAbsent(i, new HashSet<>());
                chars.get(i).add(word.charAt(i));
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while (!q.isEmpty()) {
            int l = q.size();
            while(l > 0) {
                StringBuilder sb = new StringBuilder(q.poll());
                if(sb.toString().equals(endWord)) {
                    return distance;
                }
                for(int i = 0; i < sb.length(); i++) {
                    char org = sb.charAt(i);
                    for(char c: chars.get(i)) {
                        if(c != org) {
                            sb.setCharAt(i, c);
                            if(words.contains(sb.toString()) && !visited.contains(sb.toString())) {
                                q.add(sb.toString());
                                visited.add(sb.toString());
                            }
                            sb.setCharAt(i, org);
                        }
                    }
                }
                l--;
            }
            distance += 1;
        }

        return 0;
    }
}