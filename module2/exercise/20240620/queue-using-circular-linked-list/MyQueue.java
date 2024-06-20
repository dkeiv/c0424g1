public class MyQueue implements IMyQueue {
    Node front;
    Node rear;

    public MyQueue() {
        front = null;
        rear = null;
    }

    @Override
    public void enqueue(Node node) {
        if (front == null && rear == null) {
            front = node;
            rear = node;
            node.next = front;
        } else {
            rear.next = node;
            rear = node;
            rear.next = front;
        }
    }

    @Override
    public void dequeue() {
        if (front == null && rear == null) {
            return;
        }
        if (front == rear) {
            front = null;
            rear = null;
            return;
        }
        Node tmp = front;
        front = front.next;
        rear.next = front;
        tmp.next = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }

        Node cur = front;
        do {
            System.out.println(cur.getData());
            cur = cur.next;
        } while (cur != front);
    }
}
