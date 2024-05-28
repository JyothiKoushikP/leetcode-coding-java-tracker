

import static java.lang.Math.nextUp;

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
    boolean[] didFinish = new boolean[2];
    int[] cousin_one = new int[2];
    int[] cousin_two = new int[2];

    public boolean isCousins(TreeNode root, int x, int y) {
        Arrays.fill(cousin_one, -1);
        Arrays.fill(cousin_two, -1);
        dfsTraverse(root,0,x,y);
        boolean condition1 = (cousin_one[0] != cousin_two[0]) && (cousin_one[1] == cousin_two[1]);
        return condition1;
    }

    public void dfsTraverse(TreeNode node, int level, int c1, int c2) {
        if(node.left == null && node.right == null) {
            if(node.val == c1) {
                cousin_one[1] = level;
            }
            if(node.val == c2) {
                cousin_two[1] = level;
            }
            return;
        }
        if(node.val == c1) {
            cousin_one[1] = level;
            return;
        }
        if(node.val == c2) {
            cousin_two[1] = level;
            return;
        }
        if(node.left != null) {
            dfsTraverse(node.left, level + 1, c1, c2);
        }
        if(node.right != null) {
            dfsTraverse(node.right, level + 1, c1, c2);
        }
        if(!didFinish[0] && cousin_one[1] != -1) {
            cousin_one[0] = node.val;
            didFinish[0] = true;
        }
        if(!didFinish[1] && cousin_two[1] != -1) {
            cousin_two[0] = node.val;
            didFinish[1] = true;
        }
        return;
    }
}