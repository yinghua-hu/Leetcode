class Solution {
    public int findNumberOfLIS(int[] nums) {        
        int n = nums.length;
        // int[][] dp = new int[n][n + 1]; //count of LIS of length j end with index i
        int[] dp = new int[n]; //length of LIS ending with i
        int[] count = new int[n]; // count of LIS ending with i
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);        
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int len = dp[j] + 1;
                    if (len > dp[i]) {
                        count[i] = count[j];
                        dp[i] = len;
                    }
                    else if (len == dp[i]) {
                        count[i] += count[j];
                    }                    
                }                
            }
            maxLen = Math.max(dp[i], maxLen);
        }    
        int ans = 0;
        for (int i = maxLen - 1; i < n; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];
            }            
        }
        return ans;
    }
}
