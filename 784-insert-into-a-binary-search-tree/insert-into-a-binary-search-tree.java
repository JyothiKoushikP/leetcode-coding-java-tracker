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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insertIntoTree(root, val);
        return root;
    }

    public TreeNode insertIntoTree(TreeNode node, int val) {
        if(node == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if(val < node.val) {
            node.left = insertIntoTree(node.left,val);
        } else if(val > node.val) {
            node.right = insertIntoTree(node.right,val);
        }

        return node;
    }



}