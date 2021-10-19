class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[10001];
        Arrays.fill(nextGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums2.length;
        for (int i = 0; i < n; i++) {            
            if (stack.isEmpty() || stack.peek() > nums2[i]) {
                stack.push(nums2[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                nextGreater[stack.pop()] = nums2[i];    
            }
            stack.push(nums2[i]);            
        }
        int m = nums1.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = nextGreater[nums1[i]];
        }
        return ans;
    }
}

/*
Monotonic stack 

*/
