import java.util.*;

class RandomizedSet {
    List<Integer> randomList;
    Map<Integer,Integer> currMap;

    public RandomizedSet() {
        randomList = new ArrayList<>();
        currMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!currMap.containsKey(val)) {
            currMap.put(val,randomList.size());
            randomList.add(randomList.size(),val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(currMap.containsKey(val)) {
            int lastElement = randomList.get(randomList.size() - 1);
            int idx = currMap.get(val);
            randomList.set(idx,lastElement);
            currMap.put(lastElement,idx);
            randomList.remove(randomList.size() - 1);
            currMap.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomList.size());
        return randomList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */