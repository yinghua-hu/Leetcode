class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n <= 2) {
            return 1;
        }
        int dp0 = 0;
        int dp1 = 1;
        int dp2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = dp0 + dp1 + dp2;
            dp0 = dp1;
            dp1 = dp2;
            dp2 = temp;    
        }
        return dp2;
    }
}
