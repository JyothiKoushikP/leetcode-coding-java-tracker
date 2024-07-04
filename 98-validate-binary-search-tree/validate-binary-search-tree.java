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

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        for(int i = 0; i < inorder.size() - 1; i++) {
            if(inorder.get(i) >= inorder.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraversal(TreeNode node, List<Integer> inorder) {
        if(node.left == null && node.right == null) {
            inorder.add(node.val);
            return;
        }
        if(node.left != null) {
            inOrderTraversal(node.left,inorder);
        }
        inorder.add(node.val);
        if(node.right != null) {
            inOrderTraversal(node.right,inorder);
        }
        return;
    }
}