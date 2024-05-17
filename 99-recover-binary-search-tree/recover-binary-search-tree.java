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
    List<Integer> arr = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        boolean didGetFirst = false;
        inOrder(root);
        int[] swapArray = new int[2];
        for(int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i) > arr.get(i+1)) {
                if(didGetFirst) {
                    swapArray[1] = arr.get(i+1);
                } else {
                    swapArray[0] = arr.get(i);
                    swapArray[1] = arr.get(i+1);
                    didGetFirst = true;
                }
            }
        }
        swap(root,swapArray);
    }

    public void swap(TreeNode node,int[] swapArray) {
        if (node.left == null && node.right == null || node.val == swapArray[0] || node.val == swapArray[1]) {
            if (node.val == swapArray[0] || node.val == swapArray[1]) {
                node.val = node.val == swapArray[0] ? swapArray[1] : swapArray[0];
                int temp = swapArray[0];
                swapArray[0] = swapArray[1];
                swapArray[1] = temp;
            }
        }

        if (node.left != null) {
            swap(node.left, swapArray);
        }
        if (node.right != null) {
            swap(node.right, swapArray);
        }
    }

    public void inOrder(TreeNode node) {
        if(node.left == null && node.right == null) {
            arr.add(node.val);
            return;
        }
        if(node.left != null) {
            inOrder(node.left);
        }
        arr.add(node.val);
        if(node.right != null) {
            inOrder(node.right);
        }
    }

    
}