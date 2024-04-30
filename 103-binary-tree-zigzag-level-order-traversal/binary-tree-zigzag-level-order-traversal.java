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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int curr = 0, prev = 0, level = 0;
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        List<Integer> track = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        prev = 1;
        while(!q.isEmpty()) {
            TreeNode p = q.remove();
            track.add(p.val);
            prev--;
            
            if(p.left != null) {
                q.add(p.left);
                curr++;
            } 
            if(p.right != null) {
                q.add(p.right);
                curr++;
            }

            if(prev == 0) {
                if(level % 2 != 0) {
                    Collections.reverse(track);
                }
                result.add(track);
                track = new ArrayList<>();
                prev = curr;
                curr = 0;
                level++;
            }
        }
        return result;
    }
}