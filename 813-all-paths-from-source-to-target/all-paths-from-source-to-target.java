class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer,int[]> nodes = new HashMap<>();
        int pointer = 0;
        for(int[] vertice: graph) {
            nodes.put(pointer++, vertice);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        trackAllPaths(nodes,curr,result,0,graph.length - 1);
        return result;
    }

    public void trackAllPaths(Map<Integer,int[]> nodes, List<Integer> curr, List<List<Integer>> result, int node, int target) {
        if(node == target) {
            List<Integer> l = new ArrayList<>(curr);
            result.add(l);
            return;
        }
        if(nodes.get(node).length == 0) {
            return;
        }
        for(int i : nodes.get(node)) {
            curr.add(i);
            trackAllPaths(nodes,curr,result,i,target);
            curr.remove(curr.size() - 1);
        }

        return;
    }
}