

import static java.util.Collections.min;

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
    List<Integer> io = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < io.size()-1; i++) {
            minDiff = Math.min(minDiff,io.get(i+1) - io.get(i));
        }
        return minDiff;
    }

    public void inOrderTraversal(TreeNode node) {
        if(node.left == null && node.right == null) {
            io.add(node.val);
            return;
        }
        if(node.left != null) {
            inOrderTraversal(node.left);
        }
        io.add(node.val);
        if(node.right != null) {
            inOrderTraversal(node.right);
        }
        return;
    }
}