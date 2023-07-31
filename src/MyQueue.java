

public class MyQueue<T> {
    private Node head;
    private Node rear;

    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public MyQueue() {
        head = null;
        rear = null;
        size = 0;
    }

    public void add(T value) {
        Node newNoda = new Node(value);
        if (isEmpty()) {
            head = newNoda;
            rear = newNoda;
        } else {
            rear.next = newNoda;
            rear = newNoda;
        }
        size++;
    }

    public void clear() {
        head = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;

    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T polle = head.data;
        head.next = head;
        size--;
        return polle;
    }

    public Boolean isEmpty() {
        return size == 0;
    }
}
