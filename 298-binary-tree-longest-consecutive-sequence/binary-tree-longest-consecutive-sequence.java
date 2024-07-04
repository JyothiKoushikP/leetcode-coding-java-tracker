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
    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        trackLSequence(root);
        return maxLength + 1;
    }

    public int trackLSequence(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 0;
        }   
        int maxLeft = 0, maxRight = 0;
        int currValue = root.val;
        if(root.left != null) {
            maxLeft = trackLSequence(root.left);
        }
        if(root.right != null) {
            maxRight = trackLSequence(root.right);
        }
        int l_max = 0, r_max = 0;
        if(root.left != null && root.left.val - currValue == 1) {
            l_max = 1 + maxLeft;
        }
        if(root.right != null && root.right.val - currValue == 1) {
            r_max = 1 + maxRight;
        }
        maxLength = Math.max(Math.max(l_max, r_max), maxLength);
        
        return Math.max(l_max,r_max);
    }
}