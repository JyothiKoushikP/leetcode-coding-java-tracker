class MyCircularQueue {

    int front = -1, rear = 0;
    int[] arr;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isEmpty() && front == -1) front++;
        if(isFull()) {
            return false;
        }
        if(isEmpty() && front == -1) front++;
        arr[rear % arr.length] = value;
        rear = rear + 1;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        front = front + 1;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return arr[front % arr.length];
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return arr[(rear - 1) % arr.length];
    }
    
    public boolean isEmpty() {
        return front == -1 || front == rear;
    }
    
    public boolean isFull() {
        return (rear != 0) && rear - front == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */