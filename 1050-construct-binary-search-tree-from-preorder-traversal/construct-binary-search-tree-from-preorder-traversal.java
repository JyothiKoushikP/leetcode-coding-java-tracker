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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i : preorder) {
            root = buildTree(i, root);
        }
        return root;
    }

    public TreeNode buildTree(int val, TreeNode node) {
        if(node == null) {
            node = new TreeNode(val);
            return node;
        }
        if(val > node.val) {
            node.right = buildTree(val, node.right);
        } else {
            node.left = buildTree(val, node.left);
        }

        return node;
    }

}