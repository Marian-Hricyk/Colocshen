public class MyStack {
    private Node top;
    private int size;

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        } else if (index == 0) {
            top.next = top;
        } else {
            Node current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int  size(){
        return size;
    }
    public Object peek(){
        return top.data;
    }
    public Object pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty. Cannot pop element.");
        }
        Object node=top.data;
        top.next=top;
        size--;
        return node;
    }
    public Boolean isEmpty() {
        return top == null;
    }
}
