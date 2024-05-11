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
    List<Integer> values = new ArrayList<>();
    public int goodNodes(TreeNode root) {
        getMaxNodes(root, Integer.MIN_VALUE);
        return values.size();
    }

    public void getMaxNodes(TreeNode node, int mv) {
        if(node.left == null && node.right == null) {
            mv = Math.max(mv, node.val);
            if(mv <= node.val) {
                values.add(node.val);
            }
            return;
        }
        mv = Math.max(mv, node.val);
        if(mv <= node.val) {
            values.add(node.val);
        }
        if(node.left != null) {
            getMaxNodes(node.left, mv);
        }
        if(node.right != null) {
            getMaxNodes(node.right, mv);
        }
        return;
    }

}