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
    TreeNode root = null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> track = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            track.put(inorder[i],i);
        }
        for(int i = postorder.length - 1; i >= 0; i--) {
            root = recursiveBuild(track, postorder, i, root);
        }
        return root;
    }

    public TreeNode recursiveBuild(Map<Integer,Integer> track, int[] postorder, int p, TreeNode tree) {
        if(tree == null) {
            return new TreeNode(postorder[p]);
        }
        int curr = track.get(tree.val);
        int lat = track.get(postorder[p]);
        if(lat > curr) {
            tree.right = recursiveBuild(track, postorder, p, tree.right);
        } else {
            tree.left = recursiveBuild(track, postorder, p, tree.left);
        }
        return tree;
    }
}