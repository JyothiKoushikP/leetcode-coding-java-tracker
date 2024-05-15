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
    public TreeNode pruneTree(TreeNode root) {
        boolean val = removeSubTree(root);
        return val ? root : null;
    }

    public boolean removeSubTree(TreeNode node) {
        if(node == null) {
            return false;
        }
        boolean TF = false, TF1 = false, TF2 = false;
        if(node.val == 1) {
            TF = true;
        }
        TF1 = removeSubTree(node.left);
        if(!TF1) {
            node.left = null;
        }
        TF2 = removeSubTree(node.right);
        if(!TF2) {
            node.right = null;
        }
        return TF || TF1 || TF2;
    }

}