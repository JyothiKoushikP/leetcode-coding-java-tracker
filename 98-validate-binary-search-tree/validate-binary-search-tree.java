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
        List<Integer> track = new ArrayList();
        inorderTraversal(root, track);
        for(int i = 1; i < track.size(); i++) {
            if(track.get(i) <= track.get(i-1)) return false;
        }
        return true;
    }

    public void inorderTraversal(TreeNode root, List<Integer> track) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left,track);
        track.add(root.val);
        inorderTraversal(root.right,track);
    }


}