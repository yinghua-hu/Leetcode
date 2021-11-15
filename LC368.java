class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
                if (dp[i] == dp[j] + 1) {
                    prev[i] = j;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
            if (maxLen == dp[i]) {
                maxIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int id = maxIndex;
        while (id != -1) {
            ans.add(nums[id]);
            id = prev[id];
        }
        Collections.reverse(ans);
        return ans;
    }
}

/*
DP

1. Sort nums
2. dp[i] - the size of the largest divisible subset ends with nums[i]
    dp[i] = max{dp[j] + 1} for j < i and nums[i] % nums[j] == 0
    initially dp[i] = 1
i - 0 - n - 1
j - 0 - i - 1

time O(N^2)
space O(N)

*/
