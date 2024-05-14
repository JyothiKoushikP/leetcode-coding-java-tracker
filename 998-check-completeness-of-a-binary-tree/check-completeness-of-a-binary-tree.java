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
    public boolean isCompleteTree(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        int maxDepth = dfs(root,0);
        int curr = 1, next = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLevel = 1;
        boolean didGetNull = false;
        while(!q.isEmpty()) {
            TreeNode c = q.remove();
            curr--;
            if(c.left != null) {
                if(currLevel == maxDepth) {
                    if(didGetNull) {
                        return false;
                    }
                } 
                q.add(c.left);
                next++;
            } else {
                if(currLevel == maxDepth) {
                    if(!didGetNull) {
                        didGetNull = true;
                    }
                } else {
                    return false;
                }
            }

            if(c.right != null) {
                if(currLevel == maxDepth) {
                    if(didGetNull) {
                        return false;
                    }
                } 
                q.add(c.right);
                next++;
            } else {
                if(currLevel == maxDepth) {
                    if(!didGetNull) {
                        didGetNull = true;
                    }
                } else {
                    return false;
                } 
            }

            if(curr == 0) {
                if(currLevel == maxDepth) {
                    return true;
                }   
                curr = next;
                next = 0;
                currLevel += 1;
            }
        }

        return false;
    }

    public int dfs(TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            return level;
        }
        int ml = level, mr = level;
        if(node.left != null) {
            ml = dfs(node.left,level + 1);
        }
        if(node.right != null) {
            mr = dfs(node.right, level + 1);
        }

        return Math.max(ml,mr);
    }
}