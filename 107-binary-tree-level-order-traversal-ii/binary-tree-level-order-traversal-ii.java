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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int curr = 1, next = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode c = q.remove();
            curr--;
            level.add(c.val);
            if(c.left != null) {
                q.add(c.left);
                next++;
            }
            if(c.right != null) {
                q.add(c.right);
                next++;
            }
            if(curr == 0) {
                curr = next;
                next = 0;
                result.add(level);
                level = new ArrayList<>();
            }
        }
        Collections.reverse(result);
        return result;
    }
}