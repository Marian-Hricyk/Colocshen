class MyArrayList<T> {
    private Object[] elements;
    private int size;


    private static final int CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (size == elements.length) {
            int newCpacity = elements.length * 2;
            Object[] newErr = new Object[newCpacity];
            for (int i = 0; i < elements.length; i++) {
                newErr[i] = elements[i];
            }
            elements = newErr;
        }
        elements[size] = value;
        size++;
    }

    public void remove(int index) {
        exception(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void clear() {

        elements = null;

        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        exception(index);
        return (T) elements[index];
    }


    private Exception exception(int index) {
        if (index < 0 || index >= size) {
            return new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return null;
    }

}
