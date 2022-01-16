class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            int skip = questions[i][1];
            int j = Math.min(n, i + skip + 1);
            dp[j] = Math.max(dp[j], dp[i] + questions[i][0]);
        }
        return dp[n];
    }
}

// [[3,2],[4,3],[4,4],[2,5]]
//    ^                 ^            3 + 2 = 5    V
//          ^                        4

// DP
// 1. dp[i] - the maximum points we get for i = 0, ..., i - 1;   i [0, n]
// 2. result -> dp[n]
// 3. initialize dp[i] to 0
// 4. for each i, if we skip, dp[i + 1] = Math.max(dp[i + 1], dp[i])
//                if we select, skip = questions[i][1], dp[i + skip + 1] = Math.max(dp[i + skip + 1], dp[i] + questions[i][0])
// time, space O(N)
