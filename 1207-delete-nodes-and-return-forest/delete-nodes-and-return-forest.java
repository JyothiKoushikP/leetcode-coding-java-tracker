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

    List<TreeNode> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i: to_delete) {
            set.add(i);
        }
        TreeNode finalTree = getForest(root);
        if(finalTree != null) {
            result.add(finalTree);
        }
        return result;
    }

    public TreeNode getForest(TreeNode node) {
        if(node == null) {
            return null;
        }
        if(set.isEmpty()) {
            return node;
        }
        if(node.left == null && node.right == null) {
            if(set.contains(node.val)) {
                set.remove(node.val);
                return null;
            }
            return node;
        }
        if(set.contains(node.val)) {
            set.remove(node.val);
            TreeNode leftTree = getForest(node.left);
            TreeNode rightTree = getForest(node.right);
            if(leftTree != null) {
                result.add(leftTree);
            }
            if(rightTree != null) {
                result.add(rightTree);
            }
            return null;
        } else {
            node.left = getForest(node.left);
            node.right = getForest(node.right);
            return node;
        }
    }


}