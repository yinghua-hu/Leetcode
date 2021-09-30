class Solution {
    int target;
    int n;
    int K;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        this.target = sum / k;
        this.K = k;
        visited = new boolean[n];
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        return dfs(nums, 0, 0, 0);
    }
    public boolean dfs(int[] nums, int group, int sum, int start) {
        if (group == K - 1) { 
            return true;
        }
        if (sum > target) {
            return false;
        }
        else if (sum == target) { // this group is done
            return dfs(nums, group + 1, 0, 0);
        }
        for (int i = start; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            if (dfs(nums, group, sum + nums[i], i + 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}

/*
sum of nums[0:n - 1], 

if (sum % k != 0) => impossible

target = sum / k

 [4,3,2,3,5,2,1]
  ^ ^
  
DFS with backtracking

visited array to record the num already used.
 
k groups, need to have group in the dfs function too

Optimizations :
1. sort the nums descending, start from larger value
target = 5
[7, 6, 2, 1, 1] abort search earlier

2. when there is duplicates,

[1, 1, 1, 2, 3, ... ]
  

Time - k * 2^N,  2*2 .. 2( N times)
Space - O(N) size of visiting array and the depth of recursion 

*/
