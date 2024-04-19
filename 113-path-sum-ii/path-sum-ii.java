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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        List<Integer> track = new ArrayList<>();
        track.add(root.val);
        sumR(root, targetSum,root.val,track);
        return result;
    }

    public void sumR(TreeNode node, int targetSum, int currSum, List<Integer> track) {
        if(node.left == null && node.right == null) {
            if(currSum == targetSum) {
                List<Integer> res = new ArrayList<>();
                for(int i: track) {
                    res.add(i);
                }
                result.add(res);
            }
            return;
        }

        if(node.left != null) {
            track.add(node.left.val);
            sumR(node.left, targetSum, currSum + node.left.val, track);
            track.remove(track.size() - 1);
        } 
        if(node.right != null) {
            track.add(node.right.val);
            sumR(node.right, targetSum, currSum + node.right.val, track);
            track.remove(track.size() - 1);
        }

        return;
    }
}