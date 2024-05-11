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
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        getPaths(s,root);
        return result;
    }

    public void getPaths(String s, TreeNode node) {
        if(node.left == null && node.right == null) {
            result.add(s + Integer.toString(node.val));
            return;
        }
        if(node.left != null) {
            getPaths(s + Integer.toString(node.val) + "->",node.left);
        }
        if(node.right != null) {
            getPaths(s + Integer.toString(node.val) + "->",node.right);
        }
    }

}