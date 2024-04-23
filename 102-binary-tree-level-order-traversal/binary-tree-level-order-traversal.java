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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> track = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        track.add(root);
        int curr = 1, next = 0;
        while(!track.isEmpty()) {
            TreeNode r = track.remove();
            arr.add(r.val);
            curr--;
            if(r.left != null) {
                track.add(r.left);
                next++;
            }
            if(r.right != null) {
                track.add(r.right);
                next++;
            }
            if(curr == 0) {
                result.add(arr);
                arr = new ArrayList<>();
                curr = next;
                next = 0;
            }
        }
        return result;
    }
}