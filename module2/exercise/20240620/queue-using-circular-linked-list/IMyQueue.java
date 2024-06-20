public interface IMyQueue {
    void enqueue(Node node);
    void dequeue();
    boolean isEmpty();
    void displayQueue();
}
