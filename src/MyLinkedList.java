public class MyLinkedList {
    private Node head;
    private int size;

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object valy) {
        Node newNode = new Node(valy);
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

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        } else if (index == 0) {
            return head;
        } else {
            Node cler = head;
            for (int i = 0; i < index; i++) {
                cler = cler.next;
            }
            return cler.data;
        }
    }

}
