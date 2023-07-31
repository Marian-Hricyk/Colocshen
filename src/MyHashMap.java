public class MyHashMap<K, V> {
    private Node[] nodes;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final Object NULL_CEY = new Object();


    private class Node<K,V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        nodes = new Node[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            key = (K) NULL_CEY;
        }
        int index = getIndex(key);
        getAdd(index, key, value, nodes);
        size++;


        if (size == nodes.length) {
            resize();
        }
    }

    private void resize() {
        int lengthNewNodes = nodes.length * 2;
        Node[] newNodes = new Node[lengthNewNodes];
        int index;

        for (int i = 0; i < nodes.length; i++) {
            index = getIndex((K) nodes[i].key);
            getAdd(index, (K) nodes[i].key, (V) nodes[i].value, newNodes);
        }
        nodes = newNodes;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node current = nodes[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    nodes[index] = current.next;
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
        nodes = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(K key) {
        int index = getIndex(key);
        Node cerent = nodes[index];

        while (cerent != null) {
            if (cerent.key.equals(key)) {
                return cerent.value;
            }
            cerent = cerent.next;
        }
        return null;
    }

    private int getIndex(K key) {
        int heshcode = key.hashCode();
        return Math.abs(heshcode) % nodes.length;
    }

    private void getAdd(int index, K key, V value, Node[] nodes1) {
        Node newNode = new Node(key, value);
        if (nodes1[index] == null) {
            nodes1[index] = newNode;
        } else {
            Node creint = nodes1[index];

            while (creint.next != null) {
                if (creint.key.equals(key)) {
                    creint.value = value;
                    return;
                }
                creint = creint.next;
            }
            if (creint.key.equals(key)) {
                creint.value = value;
            } else {
                creint.next = newNode;
            }
        }
    }
}
