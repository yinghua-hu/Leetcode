class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + grid[1][i - 1];
        }
        long[] postsum = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            postsum[i] = postsum[i + 1] + grid[0][i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(presum[i], postsum[i + 1]));
        }
        return ans;
    }
}
