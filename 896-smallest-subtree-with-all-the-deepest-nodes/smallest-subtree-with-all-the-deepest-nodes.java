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

    TreeNode[] result = new TreeNode[1];

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = dfs(root,0);
        int depth = getShortestParent(root,maxDepth,0);
        return result[0];
    }

    public int dfs(TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            return level;
        }
        int leftLevel = level, rightLevel = level;
        if(node.left != null) {
            leftLevel = dfs(node.left,level + 1);
        }
        if(node.right != null) {
            rightLevel = dfs(node.right,level + 1);
        }

        return Math.max(leftLevel,rightLevel);
    }

    public int getShortestParent(TreeNode node, int maxDepth, int level) {
        if(node == null) {
            return level - 1;
        }
        int leftDepth = getShortestParent(node.left,maxDepth, level + 1);
        int rightDepth = getShortestParent(node.right,maxDepth, level + 1);

        if(leftDepth == maxDepth && rightDepth == maxDepth) {
            result[0] = node;
        }

        return Math.max(leftDepth,rightDepth);
    }

}