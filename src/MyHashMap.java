public class MyHashMap {
    private Node[] beket;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;


    private class Node {
        Object key;
        Object valoe;
        Node next;

        public Node(Object key, Object valoe) {
            this.key = key;
            this.valoe = valoe;
            next = null;
        }
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        beket = new Node[capacity];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);
        if (beket[index] == null) {
            beket[index] = newNode;
        } else {
            Node creint = beket[index];

            while (creint.next != null) {
                if (creint.key.equals(key)) {
                    creint.valoe = value;
                    return;
                }
                creint = creint.next;
            }
            if (creint.key.equals(key)) {
                creint.valoe = value;
            } else {
                creint.next = newNode;
            }
        }
        size++;
    }

    public void remove(Object key) {
        int index = getIndex(key);
        Node current = beket[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    beket[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        for (int i = 0; i < beket.length; i++) {
            beket[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Node cerent = beket[index];

        while (cerent != null) {
            if (cerent.key.equals(key)) {
                return cerent.valoe;
            }
            cerent = cerent.next;
        }
        return null;
    }

    private int getIndex(Object key) {
        int heshcode = key.hashCode();
        return Math.abs(heshcode) % beket.length;
    }
}
