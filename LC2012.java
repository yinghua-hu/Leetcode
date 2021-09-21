class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n]; // preMax[i] - the max value up to index i
        int[] postMin = new int[n + 1]; //postMin[i] - the min value i till n - 1
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }        
        postMin[n] = 100001;
        for (int i = n - 1; i >= 0; i--) {
            postMin[i] = Math.min(postMin[i + 1], nums[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > preMax[i - 1] && nums[i] < postMin[i + 1]) {
                ans += 2;
            }
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
}
