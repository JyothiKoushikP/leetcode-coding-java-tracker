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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,Set<Integer>> parentMap = new HashMap<>();
        collectParents(root, -1, parentMap);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int minutes = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                int curr = q.poll();
                Set<Integer> n = parentMap.get(curr);
                for(int i: n) {
                    if(!visited.contains(i)) {
                        visited.add(i);
                        q.add(i);
                    }
                }
                len--;
            }
            minutes += 1;
        }
        return minutes - 1;
    }

    public void collectParents(TreeNode node, int parent, Map<Integer,Set<Integer>> parentMap) {
        if(node.left == null && node.right == null) {
            Set<Integer> neighbors = new HashSet<>();
            if(parent != -1) {
                neighbors.add(parent);
            }
            parentMap.put(node.val, neighbors);
            return;
        }

        Set<Integer> neighbors = new HashSet<>();
        if(parent != -1) {
            neighbors.add(parent);
        }

        if(node.left != null) {
            neighbors.add(node.left.val);
            collectParents(node.left, node.val, parentMap);
        }
        if(node.right != null) {
            neighbors.add(node.right.val);
            collectParents(node.right, node.val, parentMap);
        }
        parentMap.put(node.val, neighbors);
        return;
    }

}