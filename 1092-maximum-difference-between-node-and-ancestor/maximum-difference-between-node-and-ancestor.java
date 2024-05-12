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
    int[] mdf = new int[1];
    int[] maxdf = new int[2];


    public int maxAncestorDiff(TreeNode root) {
        mdf[0] = Integer.MIN_VALUE;
        maxdf[0] = root.val;
        maxdf[1] = root.val;
        getMaxDiff(root);
        return mdf[0];
    }

    public void getMaxDiff(TreeNode node) {
        if(node.left == null && node.right == null) {
            mdf[0] = Math.max(mdf[0],Math.abs(node.val - maxdf[0]));
            mdf[0] = Math.max(mdf[0],Math.abs(node.val - maxdf[1]));
            return;
        }
        mdf[0] = Math.max(mdf[0],Math.abs(node.val - maxdf[0]));
        mdf[0] = Math.max(mdf[0],Math.abs(node.val - maxdf[1]));

        int previousMin = maxdf[0];
        int previousMax = maxdf[1];

        maxdf[0] = Math.min(maxdf[0],node.val);
        maxdf[1] = Math.max(maxdf[1],node.val);

        if(node.left != null) {
            getMaxDiff(node.left);
        }
        if(node.right != null) {
            getMaxDiff(node.right);
        }
        
        maxdf[0] = previousMin;
        maxdf[1] = previousMax;

    }

}