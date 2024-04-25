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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) {
            return result;
        }
        List<List<Integer>> totalTrack = new ArrayList();
        List<Integer> level = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int curr = 1, next = 0;
        while (!q.isEmpty()) {
            TreeNode c = q.remove();
            level.add(c.val);
            curr--;
            if(c.left != null) {
                q.add(c.left);
                next++;
            }
            if(c.right != null) {
                q.add(c.right);
                next++;
            }
            if(curr == 0) {
                totalTrack.add(level);
                curr = next;
                next = 0;
                level = new ArrayList<>();
            }
        }

        for(List<Integer> l: totalTrack) {
            result.add(l.get(l.size()-1));
        }

        return result;
    }




}