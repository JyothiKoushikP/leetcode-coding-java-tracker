class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet();
        for(String email: emails) {
            StringBuilder parse = new StringBuilder();
            boolean didReachIgnore = false;
            boolean didReach = false;
            for(char c: email.toCharArray()) {
                if(c == '@'){
                    didReach = true;
                    didReachIgnore = false;
                }
                if(!didReach && c == '+'){
                    didReachIgnore = true;
                    continue;
                }
                if(!didReach && c == '.'){
                    continue;
                }
                if(!didReachIgnore) {
                    parse.append(c);
                }
            }
            emailSet.add(parse.toString());
        }
        System.out.println(emailSet.toString());
        return emailSet.size();
    }
}