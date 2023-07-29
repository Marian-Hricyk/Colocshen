import java.util.Arrays;

class MyArrayList {
    private Object[] err;
    private int size;


    private static final int capacity = 10;

    public MyArrayList() {
        err = new Object[capacity];
        size = 0;
    }

    public void add(Object value) {
        ensureCapacity(size + 1);
        err[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            err[i] = err[i + 1];
        }
        err[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i <= size; i++) {
            err[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return err[index];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = err.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1); // Increase capacity by 50%
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            err = Arrays.copyOf(err, newCapacity);
        }
    }

}
