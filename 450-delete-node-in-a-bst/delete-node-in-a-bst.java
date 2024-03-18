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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = deleteNodeinBST(root,key);
        return root;
    }

    public TreeNode deleteNodeinBST(TreeNode node, int val) {
        if(node == null) {
            return null;
        }
        int curr = node.val;
        if(curr == val) {
                        if(node.left == null && node.right == null) {
                return null;
            }
            if(node.left == null) {
                return node.right;
            }
            if(node.right == null) {
                return node.left;
            }
            TreeNode leftTree = node.left;
            TreeNode rightTree = node.right;
            node = leftTree;
            TreeNode p = leftTree;
            while(p.right != null) {
                p = p.right;
            }
            p.right = rightTree;
            return node;
        } else if(curr < val) {
            node.right = deleteNode(node.right,val);
        } else {
            node.left = deleteNode(node.left,val);
        }
        return node;
    }
}