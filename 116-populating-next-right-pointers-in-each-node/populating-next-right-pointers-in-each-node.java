/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> track = new LinkedList<>();
        List<Node> level = new ArrayList<>();
        int curr = 1, pow = curr;
        track.add(root);
        while(!track.isEmpty()) {
            Node rm = track.remove();
            level.add(rm);
            pow--;
            if(rm.left != null) {
                track.add(rm.left);
            }
            if(rm.right != null) {
                track.add(rm.right);
            }
            if(pow == 0) {
                for(int i = 0; i < level.size(); i++) {
                    if(i == level.size() - 1) {
                        level.get(i).next = null;
                    } else {
                        level.get(i).next = level.get(i+1);
                    }
                }
                level = new ArrayList<>();
                curr *= 2;
                pow = curr;
            }
        }

        return root;
    }
}