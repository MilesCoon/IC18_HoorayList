// Java generic data type: placeholder (variable) for actual data type
// E == element
public class HoorayList <E>{
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    // Array to store all of our data
    private E[] data;

    public HoorayList(int initialCapacity) {
        capacity = initialCapacity;
        size = 0;
        data = (E[]) new Object[initialCapacity];
    }

    public HoorayList() {
        this(DEFAULT_CAPACITY);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size+1));
        }
        return data[index];
    }

    public E set(int index, E element) {
        E temp = get(index);
        data[index] = element;
        return temp;
    }

    public void ensureCapacity(int minCapacity) {
        // Check if
        if (minCapacity > capacity) {
            // 1) make a new array (size = minCapacity)
            E[] tempData = (E[]) new Object[minCapacity];
            // 2) transfer all data from old array (data) to new array
            for (int i = 0; i < capacity; i++) {
                tempData[i] = data[i];
            }
            // 3) update data to reference new array
            data = tempData;
            // 4) update capacity
            capacity = minCapacity;
        }
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            // Check for match
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1; // Not found
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public boolean add(int index, E element) {
        // Check to see if HoorayList is full
        // if so. double the capacity of the HoorayList
        if (size >= capacity) {
            ensureCapacity(2 * capacity);
        }
        // Inserts the specified element at the specified position in this list
        for (int i = size; i > index; i--) {
            // Shift elements up by 1
            data[i] = data[i-1];
        }
        // Insert new element
        data[index] = element;
        // Increment the size by 1
        size++;
        return true;
    }

    public boolean add(E element) {
        return add(size, element);
    }

    public String toString() {
        // [1, 2, 3, 4, 5, Hooray!]
        String output = "[";
        for (int i = 0; i < size; i++) {
            output += data[i] + ", ";
        }
        return output + "Hooray!]";
    }

    public void clear() {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be greater than 0 and less than " + size);
        }
        E removedElement = data[index];
        for (int i = index; i < size; i++) {
            // Shift elements up by 1
            data[i] = data[i+1];
        }
        size--;
        return removedElement;
    }

    public boolean remove(E element) {
        int eIndex = indexOf(element);
        if (eIndex != -1) {
            remove(eIndex);
            return true;
        } else { return false; }
    }
}
