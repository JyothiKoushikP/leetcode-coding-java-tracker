class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }

        int hcf = jug2Capacity >= jug1Capacity ? getHcf(jug1Capacity, jug2Capacity) : getHcf(jug2Capacity, jug1Capacity);

        return (targetCapacity % hcf == 0);

    }

    public int getHcf(int x1, int x2) {
        if(x2 % x1 == 0) {
            return x1;
        }
        return getHcf(x2%x1,x1);
    }

}