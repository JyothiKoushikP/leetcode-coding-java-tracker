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
TC: O(n)
SC: O(logn)
Recursive Approach for the same
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return sumR(root, targetSum, root.val);
    }

    public boolean sumR(TreeNode node, int targetSum, int currSum) {
        if(node.left == null && node.right == null) {
            return currSum == targetSum;
        }
        boolean res1 = false, res2 = false;

        if(node.left != null) {
            res1 = sumR(node.left, targetSum, currSum + node.left.val);
        } 
        if(node.right != null) {
            res2 = sumR(node.right, targetSum, currSum + node.right.val);
        }

        return res1 || res2;
    }
}