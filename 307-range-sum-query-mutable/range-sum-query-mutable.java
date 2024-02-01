public class NumArray {
    int[] tree;
    int[] nums;

    NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[4 * nums.length];
        buildSumQueryTree(1, 0, nums.length - 1);
    }

    public void buildSumQueryTree(int node, int lo, int hi) {
        if(lo == hi) {
            tree[node] = nums[lo];
            return;
        }
        int leftNode = 2 * node;
        int rightNode = 2 * node + 1;
        int mid = lo + (hi - lo) / 2;

        buildSumQueryTree(leftNode, lo, mid);
        buildSumQueryTree(rightNode, mid + 1, hi);

        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public void update(int index, int val) {
        update(1, 0, nums.length - 1, index, val);
    }
    private void update(int node, int lo, int hi, int index, int val) {
        if(lo == hi) {
            nums[lo] = val;
            tree[node] = val;
            return;
        }

        int leftNode = 2 * node;
        int rightNode = 2 * node + 1;
        int mid = lo + (hi - lo) / 2;

        if(index <= mid)
            update(leftNode, lo, mid, index, val);
        else
            update(rightNode, mid + 1, hi, index, val);

        tree[node] = tree[leftNode] + tree[rightNode];

    }
    public int sumRange(int left, int right) {
        return sumRange(1, 0, nums.length - 1, left, right);
    }

    private int sumRange(int node, int lo, int hi, int ql, int qr) {
        if(hi < ql || lo > qr)
            return 0;
        if(lo == hi)
            return tree[node];
        if(lo >= ql && hi <= qr)
            return tree[node];

        int leftNode = 2 * node;
        int rightNode = 2 * node + 1;
        int mid = lo + (hi - lo) / 2;

        int leftSum = sumRange(leftNode, lo, mid, ql, qr);
        int rightSum = sumRange(rightNode, mid + 1, hi, ql, qr);

        return leftSum + rightSum;
    }
}