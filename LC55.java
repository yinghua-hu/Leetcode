class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}

/*
Dynamic Programming

dp[i] - if you can jump to index i
dp[0] - true

dp[i] = dp[j] && j + nums[j] >= i for j = 0, ..., i - 1

for (int i = 1; i < n; i++) {
    for (int j = 0; j < i; j++) {
        if (dp[j] && j + nums[j] >= i) {
            dp[i] = true;
            break;
        }
    }
}

return dp[n - 1]

Time O(N ^ 2)

*/
