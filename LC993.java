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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int count = 0; // count x or y
            while (size > 0) {
                TreeNode cur = que.poll();
                if (cur.val == x || cur.val == y) {
                    count++;
                }
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x && cur.right.val == y) || (cur.right.val == x && cur.left.val == y)) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
                size--;
            }
            if (count == 1) {
                return false;
            }
            else if (count == 2) {
                return true;
            }
        }
        return false;
    }
}

/*
BFS to traverse level order
in each level we keep a count and increment if we meet x or y

check if x and y belong to the same parent, this can be done when we add nodes to the queue

count = 1 => return false;
count = 2 => return true;
count = 0 => continue to search the next level

time O(N)
space O(N)

*/
