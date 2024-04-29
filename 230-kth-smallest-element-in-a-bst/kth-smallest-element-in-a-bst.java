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
    List<Integer> track = new ArrayList();;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return track.get(k-1);
    }

    public void inOrder(TreeNode node) {
        if(node.left == null && node.right == null) {
            track.add(node.val);
            return;
        }
        if(node.left != null) {
            inOrder(node.left);
        }
        track.add(node.val);
        if(node.right != null) {
            inOrder(node.right);
        }
    }

}