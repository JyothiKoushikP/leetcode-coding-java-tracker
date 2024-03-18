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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> index = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            index.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++) {
            root = insertTree(root,preorder,index, i);
        }
        return root;
    }

    public TreeNode insertTree(TreeNode node,int[] preorder,Map<Integer,Integer> index, int p) {
        if(node == null) {
            return new TreeNode(preorder[p]);
        }
        int curr = index.get(node.val);
        int x = index.get(preorder[p]);
        if(curr < x) {
            node.right = insertTree(node.right,preorder,index,p);
        } else {
            node.left = insertTree(node.left,preorder,index,p);
        }
        return node;
    }

}