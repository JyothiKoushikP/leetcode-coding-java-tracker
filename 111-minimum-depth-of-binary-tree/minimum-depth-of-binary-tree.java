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

/*
DFS: O(n)
*/

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root,1);
    }

    public int dfs(TreeNode node, int len) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }
        if(node.left == null && node.right == null) {
            return len;
        }
        return Math.min(dfs(node.left,len+1),dfs(node.right,len+1));
    }
}