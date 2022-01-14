class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ones += nums[i];
        }
        int zeros = 0;        
        for (int i = 0; i < ones; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
        }
        int ans = zeros;
        for (int i = 0; i + ones < 2 * n; i++) {
            if (nums[i % n] == 0) {
                zeros--;
            }
            if (nums[(i + ones) % n] == 0) {
                zeros++;
            }
            ans = Math.min(ans, zeros);
        }
        return ans;
    }
}

// [0,1,0,1,1,0,0] => [0,0,1,1,1,0,0]
// [1,1,0,0,1]
// [1,1,0,0,1,1,1,0,0,1]
//          1,1,1
// 1. to deal with circular, concatenate two arrays
// 2. think backward
// [0,0,0,        1,1,1
// 3. sliding window

// O(N)
// O(N) -> O(1)
