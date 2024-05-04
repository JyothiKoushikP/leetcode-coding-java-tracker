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

    List<Integer> list = new ArrayList();
    Map<Integer,Integer> track = new HashMap<>();

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        io(root);
        int suffixSum = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            int x = list.get(i);
            track.put(x, x + suffixSum);
            suffixSum += x;
        }

        updateTree(root);

        return root;
    }

    public void io(TreeNode node) {
        if(node == null) {
            return;
        }
        io(node.left);
        list.add(node.val);
        io(node.right);
    }

    public void updateTree(TreeNode node) {
        if(node == null) {
            return;
        }
        updateTree(node.left);
        node.val = track.get(node.val);
        updateTree(node.right);
    }


}