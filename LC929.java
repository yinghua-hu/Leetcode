class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> cleanedSet = new HashSet<>();
        for (String email : emails) {
            char[] s = email.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean local = true;
            boolean plus = false;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '@') {
                    local = false;                    
                }
                if (!local) {
                    sb.append(s[i]);
                }
                else {// local
                    if (s[i] == '+') {
                        plus = true;
                    }
                    if (s[i] != '.' && !plus) {
                        sb.append(s[i]);
                    }
                }
            }
            cleanedSet.add(sb.toString());
        }
        return cleanedSet.size();
    }
}

/*
1. Iterate through strings of emails
2. Clean the email to the simplest form and put in a Set
3. Return the size of set
Time O(N) - N is the total number of characters
Space O(M) - M is the number of cleaned emails, use Set for extra space, 
*/
