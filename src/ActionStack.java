/**
 * A hand-written generic stack (linked-node based), used here to keep
 * a history of recent actions performed on student records (Requirement 3).
 */
public class ActionStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> top;
    private int size;

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        return isEmpty() ? null : top.data;
    }

    public boolean isEmpty() { return top == null; }

    public int size() { return size; }

    /** Prints the most recent action first, without removing anything. */
    public void display() {
        if (isEmpty()) {
            System.out.println("No recent actions recorded.");
            return;
        }
        System.out.println("---- Recent Actions (most recent first) ----");
        Node<T> cur = top;
        int i = 1;
        while (cur != null) {
            System.out.println(i++ + ". " + cur.data);
            cur = cur.next;
        }
    }
}
