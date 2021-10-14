class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }            
        }
        return dp[n];
    }
}

/*
DP

dp[i] - the least number of perfect square numbers that sum to i

dp[0] = 0

dp[i] = Integer.MAX_VALUE / 2 when i >= 1 and i <= n

dp[i] = Math.min(dp[i - 1] + 1, dp[i - 4] + 1, ... )

i = 1 -> n    => n iterations

j * j -> i    => sqrt(i) iterations

    dp[i] = Math.min(dp[i - j * j] + 1) for all j * j <= i

dp[n]

Time O(n * sqrt(n)) < 10 ^ 6
Space O(n)

*/
