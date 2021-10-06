class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            ans.add(nums[i]);
        }
        return ans;
    }
}

/*
Greedy
[4,3,2,7,8,2,3,1]
[1,2,3,4,x,x,7,8]


for (int i = 0; i < n; i++) {
    while (nums[nums[i] - 1] != nums[i]) {
        int temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
    }
}

Time - O(n), Space - O(1)

*/
