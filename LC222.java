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
    public int countNodes(TreeNode root) {
        int lo = 1;
        int h = getHeight(root);
        int hi = (int) Math.pow(2, h);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!hasK(root, mid)) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }            
        }
        return lo - 1;
    }
    
    public int getHeight(TreeNode root) {
        int i = 0;
        while (root != null) {
            i++;
            root = root.left;
        }
        return i;
    }
    
    public boolean hasK(TreeNode root, int K) {
        List<Integer> path = new ArrayList<>();
        int i = K;
        while (i > 0) {
            path.add(i);
            i /= 2;
        }
        TreeNode node = root;
        for (i = path.size() - 1; i > 0; i--) {
            if (node == null) {
                return false;
            }
            if (path.get(i - 1) % 2 == 0) {
                node = node.left;
            }
            else {
                node = node.right;
            }            
        }
        return node != null;
    }
}

/*
[7, 3, 1]
O(logN * logN)
O(1)


*/
