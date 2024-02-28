/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node itr=head;
    Node front=head;
    while(itr!=null) //Step 1 for cloning the next Nodes in the original list
    {
        front=itr.next;
        Node copy=new Node(itr.val);
        itr.next=copy;
        copy.next=front;
        itr=front;
    }
    itr=head;
    while(itr!=null) //Step 2 for cloning the random Nodes in the original list
    {
        if(itr.random!=null)
        {
            itr.next.random=itr.random.next;
        }
        itr=itr.next.next;
    }
//Step 3 for separating the original and the cloned list.
    Node dummy=new Node(0);
    Node cp=dummy;
    itr=head;
    while(itr!=null)
    {
        front=itr.next.next;
        cp.next=itr.next;
        itr.next=front;
        cp=cp.next;
        itr=itr.next;
    }
    return dummy.next;
    }
}
