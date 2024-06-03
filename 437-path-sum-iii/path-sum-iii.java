import java.util.HashMap;
import java.util.Map;

class Solution {
    private int result = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case to handle when path sum equals targetSum
        dfs(root, 0, targetSum, prefixSumCount);
        return result;
    }
    
    private void dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return;
        }
        
        currentSum += node.val;
        
        // Check if there is a prefix sum that equals currentSum - targetSum
        result += prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        
        // Add current sum to the prefixSumCount map
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        
        // Recur to left and right children
        dfs(node.left, currentSum, targetSum, prefixSumCount);
        dfs(node.right, currentSum, targetSum, prefixSumCount);
        
        // Remove current sum from the map after returning from recursion to maintain the correct state
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }
}
