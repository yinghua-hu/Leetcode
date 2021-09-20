class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        Map<Integer, Integer> num2count = new HashMap<>();
        for (int num : changed) {
            num2count.put(num, num2count.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[n / 2];        
        int i = 0;
        for (int num : changed) {
            if (!num2count.containsKey(num)) {
                continue;
            }
            ans[i] = num;
            i++;
            decrement(num2count, num);
            if (!num2count.containsKey(num * 2)) {
                return new int[0];
            }                                    
            decrement(num2count, num * 2);
        }
        return ans;
    }
    
    public void decrement(Map<Integer, Integer> map, int num) {
        if (map.get(num) == 1) {
            map.remove(num);
        }
        else {
            map.put(num, map.get(num) - 1);
        }                
    }
}
