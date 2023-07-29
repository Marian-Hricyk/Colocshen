

public class MyQueue {
    private Node head;
    private Node rear;

    private int size;

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }
    }

    public MyQueue() {
        head = null;
        rear = null;
        size = 0;
    }

    public void add(Object valy) {
        Node newNoda = new Node(valy);
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

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;

    }

    public Object poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object polle = head.data;
        head.next = head;
        size--;
        return polle;
    }

    public Boolean isEmpty() {
        return size == 0;
    }
}
