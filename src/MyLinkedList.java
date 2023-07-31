public class MyLinkedList<T> {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node crnel = head;
            while (crnel.next != null) {
                crnel = crnel.next;
            }
            crnel.next = newNode;

        }
        size++;
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        } else if (index == 0) {
            head = head.next;
        } else {
            Node crnel = head;
            for (int i = 0; i < index - 1; i++) {
                crnel = crnel.next;
            }
            crnel.next = crnel.next.next;
        }
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        } else if (index == 0) {
            return (T) head;
        } else {
            Node cler = head;
            for (int i = 0; i < index; i++) {
                cler = cler.next;
            }
            return cler.data;
        }
    }

}
