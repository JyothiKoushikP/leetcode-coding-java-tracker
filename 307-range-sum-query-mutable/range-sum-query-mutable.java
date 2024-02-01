class NumArray {

    class Node {
        int start;
        int end;
        int data;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;
    
    public NumArray(int[] nums) {
        root = constructTree(nums, 0, nums.length-1);
    }

    public Node constructTree(int[] nums, int start, int end) {
        if(start == end) {
            Node leaf = new Node(start,end);
            leaf.data = nums[start];
            return leaf;
        }
        Node newNode = new Node(start,end);
        int mid = (start + end) / 2;
        newNode.left = constructTree(nums, start, mid);
        newNode.right = constructTree(nums,mid + 1,end);
        newNode.data = newNode.left.data + newNode.right.data;
        return newNode;
    }

    public void update(int index, int val) {
        root.data = updateTree(root,index,val);
    }

    public int updateTree(Node root, int index, int val) {
        if(index >= root.start && index <= root.end) {
            if(index == root.start && index == root.end) {
                root.data = val;
                return root.data;
            } else {
            int leftAns = updateTree(root.left, index, val);
            int rightAns = updateTree(root.right, index, val);
            root.data = leftAns + rightAns;
            return root.data;
            }
        }
        return root.data;
    }
    
    public int sumRange(int left, int right) {
        return query(root,left,right);
    }

    public int query(Node node, int left, int right) {
        if(node.start >= left && node.end <= right) {
            return node.data;
        } else if(node.start > right || node.end < left) {
            return 0;
        } else {
            int leftSum = query(node.left, left, right);
            int rightSum = query(node.right, left, right);
            return leftSum + rightSum;
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */