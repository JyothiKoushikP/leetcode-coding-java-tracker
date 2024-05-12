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
    int[] mdf = new int[1];
    List<Integer> res = new ArrayList();

    public int maxAncestorDiff(TreeNode root) {
        mdf[0] = Integer.MIN_VALUE;
        getMaxDiff(root);
        return mdf[0];
    }

    public void getMaxDiff(TreeNode node) {
        if(node.left == null && node.right == null) {
            for(int i = 0; i < res.size(); i++) {
                mdf[0] = Math.max(mdf[0],Math.abs(res.get(i) - node.val));
            }
            return;
        }
        for(int i = 0; i < res.size(); i++) {
            mdf[0] = Math.max(mdf[0],Math.abs(res.get(i) - node.val));
        }
        res.add(node.val);
        if(node.left != null) {
            getMaxDiff(node.left);
        }
        if(node.right != null) {
            getMaxDiff(node.right);
        }
        res.remove(res.size() - 1);
    }

}