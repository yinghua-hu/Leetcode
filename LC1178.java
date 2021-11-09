class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> state2count = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            state2count.put(mask, state2count.getOrDefault(mask, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            int l = puzzle.length() - 1;
            int count = 0;
            char[] s = puzzle.toCharArray();
            for (int i = 0; i < (1 << l); i++) {
                int state = (1 << (s[0] - 'a'));
                for (int j = 0; j < l; j++) {
                    if (((1 << j) & i) > 0) {
                        state |= (1 << (s[j + 1] - 'a'));
                    } 
                }
                count +=  state2count.getOrDefault(state, 0);
            }
            ans.add(count);
        }
        return ans;
    }
}

/*
1. we can use bitmask to represent a word

a - 0
b - 1

0001 - "aaa"
2. use a hashmap to store the count of the bit masks
1 - 3
3. for each puzzle, we need to set the bit for the first letter, also enumerate all the subsets for the rest of digits
   2^6 subsets 
4. When we iterate through subsets, we can add the count in the hashmap generated in step2, output the total count for each puzzle

time
a. step 1 and 2 O(words.length * avg(word length))
b. step 3 and 4 O(puzzle.length * 2^6 * 6)
O(a + b)
space
O(count of bitmasks) - max possiblity of bitmasks for the words is 2^26
*/
