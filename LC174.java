class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n]; //dp[i][j] - minimum energy required at point[i, j] so that knight can reach point[m - 1, n - 1]
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                    continue;
                }
                int next = Integer.MAX_VALUE;
                if (i < m - 1) {
                    next = Math.min(next, dp[i + 1][j]);
                }
                if (j < n - 1) {
                    next = Math.min(next, dp[i][j + 1]);
                }
                dp[i][j] = Math.max(1, next - dungeon[i][j]);                                
            }
        }
        return dp[0][0];
    }
}


/*

DP

dp[i][j] - minimum energy required at point[i, j] so that knight can reach point[m - 1, n - 1]

Go backwards, from the lower right corner to the upper left corner

i = m - 1 j = n - 1

[energy at m - 1, n - 1] + dungeon[m - 1][n - 1] >= 1 => [energy at m - 1, n - 1] >= 1 - dungeon[m - 1][n - 1]

dp[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1]

1. [energy at i, j] + dungeon[i][j] >= min(dp[i + 1][j], dp[i][j + 1])
2. [energy at i, j] >= 1

[energy at i, j] >= max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])

dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])

output : dp[0][0]

time, space - O(m * n)

*/
