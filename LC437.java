/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int target;
    Map<Integer, Integer> sum2count;
    int ans;
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.ans = 0;
        sum2count = new HashMap<>();
        sum2count.put(0, 1);
        preorder(root, 0);
        return ans;
    }
    public void preorder(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        ans += sum2count.getOrDefault(sum - target, 0);
        sum2count.put(sum, sum2count.getOrDefault(sum, 0) + 1);
        preorder(node.left, sum);
        preorder(node.right, sum);
        sum2count.put(sum, sum2count.get(sum) - 1);
        sum -= node.val;
    }
}

/*
presum on a tree, hashmap, preorder traversal, backtracking

Time - O(N)
Space - O(N)

*/
