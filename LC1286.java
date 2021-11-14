class CombinationIterator {
    List<String> combs;
    int index;
    public CombinationIterator(String characters, int combinationLength) {
        combs = new LinkedList<>();
        char[] s = characters.toCharArray();
        int n = s.length;
        for (int i = (1 << n) - 1; i >= 0; i--) {
            if (Integer.bitCount(i) != combinationLength) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (((i >> (n - 1 - j)) & 1) > 0) {
                    sb.append(s[j]);
                }                                
            }
            combs.add(sb.toString());
        }
        index = 0;
    }    
    public String next() {
        index++;
        return combs.get(index - 1);
    }    
    public boolean hasNext() {
        return index < combs.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/*
bit operation, n chars in the given string
1. bit mask (1 << n) - 1 => 0 : 2^n loops
2 check if there are combinationLength bit set, Integer.bitCount()
3 iterate from 1 through n and check if the ith bit is set, add to the string
4 add the string to the answer list

time O(2^n * n)
space O(C(n, combinationLength)) 


next() we just return the string in the list O(1)
hasnext() check if there is any string left O(1)


*/
