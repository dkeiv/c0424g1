public class Main {
    public static void main(String[] args) {
           MyQueue myQueue = new MyQueue();
           Node node1 = new Node(1);
           Node node2 = new Node(2);
           Node node3 = new Node(3);

           myQueue.enqueue(node1);
           myQueue.enqueue(node2);
           myQueue.enqueue(node3);

           myQueue.displayQueue();
    }
}
