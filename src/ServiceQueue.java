/**
 * A hand-written generic queue (linked-node based), used to process
 * student service requests strictly in order of arrival (Requirement 4).
 */
public class ServiceQueue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> front, rear;
    private int size;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    public T peekFront() {
        return isEmpty() ? null : front.data;
    }

    public boolean isEmpty() { return front == null; }

    public int size() { return size; }

    /** Prints all pending requests in arrival order without removing them. */
    public void display() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("---- Pending Service Requests (arrival order) ----");
        Node<T> cur = front;
        int i = 1;
        while (cur != null) {
            System.out.println(i++ + ". " + cur.data);
            cur = cur.next;
        }
    }
}
