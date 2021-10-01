class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] - longest length of common subsequence between text1[0:i - 1] and text2[0:j - 1]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}


/*
Time, Space - O(m * n)
Dynamic Programming

dp[m + 1][n + 1]

dp[i][j] - longest length of common subsequence between text1[0:i - 1] and text2[0:j - 1]

     i - 1
  XXXX
     j - 1
XXXXXX

1. text1[i - 1] == text2[j - 1]
dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);

2. text1[i - 1] != text2[j - 1]
dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])

initial condition
dp[0][j] = 0;
dp[i][0] = 0;

dp[i][j] = 0 i > 0 && j > 0

output
dp[m][n]


*/
