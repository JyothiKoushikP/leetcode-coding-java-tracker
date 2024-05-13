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

    Map<Integer,List<Integer>> leaves = new HashMap<>();
    int[] maxDepth = new int[1];

    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        int maxD = maxDepth[0];
        int sum = 0;
        for(int i = 0; i < leaves.get(maxD).size(); i++) {
            sum += (leaves.get(maxD)).get(i);
        }
        return sum;
    }

    public void dfs(TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            maxDepth[0] = Math.max(maxDepth[0],level);
            leaves.putIfAbsent(level, new ArrayList<>());
            leaves.get(level).add(node.val);
            return;
        }
        if(node.left != null) {
            dfs(node.left,level + 1);
        }
        if(node.right != null) {
            dfs(node.right, level + 1);
        }
        return;
    }

}