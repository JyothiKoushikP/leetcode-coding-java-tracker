class Solution {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int element : nums) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        List<Integer> sortedList = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(sortedList, (a, b) ->  b - a);

        for (int element : sortedList) {
            int freq = frequencyMap.get(element);
            if(freq >= k) {
                return element;
            }
            k -= freq;
        }
        
        return 0;
    }
}