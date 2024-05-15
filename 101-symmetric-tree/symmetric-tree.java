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
    public boolean isSymmetric(TreeNode root) {
        List<String> level = new ArrayList();
        int curr = 1, next = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode c = q.remove();
            curr--;
            if(c.left != null) {
                q.add(c.left);
                level.add(Integer.toString(c.left.val));
                next++;
            } else {
                level.add("N");
            }

            if(c.right != null) {
                q.add(c.right);
                level.add(Integer.toString(c.right.val));
                next++;
            } else {
                level.add("N");
            }

            if(curr == 0) {
                curr = next;
                next = 0;
                int l = level.size();
                if(l % 2 != 0) {
                    return false;
                }
                for(int i = 0; i < l/2; i++) {
                    if(!level.get(i).equals(level.get((l-1)-i))) {
                        return false;
                    }
                }
                level = new ArrayList();
            }
        }
        return true;
    }


}