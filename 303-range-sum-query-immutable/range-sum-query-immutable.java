class NumArray {

    int[] segment;
    int n;
    public NumArray(int[] nums) {
        this.segment = new int[4 * nums.length];
        build(0,0,nums.length - 1,nums);
        this.n = nums.length;
    }
    
    
    public void build(int index,int left,int right,int[] nums){
        if(left == right){
            segment[index] = nums[left];
            return;
        }
        
        int mid = (left + right) >> 1;
        
        build(index * 2 + 1,left,mid,nums);
        build(index * 2 + 2,mid + 1,right,nums);
        
        this.segment[index] = segment[index * 2 + 1] + segment[2 * index + 2];
    }
    
    public int query(int left,int right,int ql,int qr,int index){
        if(qr < left || right < ql){
            return 0;
        }
        
        if(left >= ql && right <= qr){
            return segment[index];
        }
        
        int mid = (left + right) >> 1;
        
        return query(left,mid,ql,qr,index * 2 + 1) + query(mid + 1,right,ql,qr,index * 2 + 2);
    }
    
    public int sumRange(int left, int right) {
        return query(0,n - 1,left,right,0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */