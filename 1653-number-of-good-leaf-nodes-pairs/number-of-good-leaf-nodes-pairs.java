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
    private int maxCount = 0;
    public int countPairs(TreeNode root, int distance) {
        maxCount = 0;
        dfs(root, distance, 1);
        return maxCount;
    }

    public List<Integer> dfs(TreeNode node, int distance, int level) {
        if(node.left == null && node.right == null) {
            List<Integer> l = new ArrayList<>();
            l.add(level);
            return l;
        }
        List<Integer> l_list = new ArrayList<>();
        List<Integer> r_list = new ArrayList<>();
        if(node.left != null) {
            l_list = dfs(node.left,distance,level + 1);
        }
        if(node.right != null) {
            r_list = dfs(node.right,distance,level + 1);
        }
        for(int i: l_list) {
            for(int j: r_list) {
                if((j - level) + (i - level) <= distance) {
                    maxCount += 1;
                }
            }
        }
        List<Integer> c = new ArrayList<>();
        c.addAll(l_list);
        c.addAll(r_list);

        return c;
    }
}