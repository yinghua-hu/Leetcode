class Solution {
    public String frequencySort(String ss) {
        char[] s = ss.toCharArray();
        Map<Character, Integer> letter2count = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < s.length; i++) {
            int count = letter2count.getOrDefault(s[i], 0) + 1;
            maxCount = Math.max(maxCount, count);
            letter2count.put(s[i], count);
        }
        ArrayList<Character>[] buckets = new ArrayList[maxCount + 1];
        for (int i = 0; i <= maxCount; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Character, Integer> entry : letter2count.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            buckets[count].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxCount; i >= 0; i--) {
            for (char ch : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);   
                }                
            }
        }
        return sb.toString();
    }
}

/*

1. HashMap <key : letter, value : count> to count each characters, also get maxFreq

2. Bucket sort 
ArrayList<Character>[] buckets = ArrayList[maxFreq]
in bucket[i], we have all the letters appearing i times

3. Iterate through bucket from high to low, and output the string (using a stringbuilder)

O(N)
O(N)

*/
