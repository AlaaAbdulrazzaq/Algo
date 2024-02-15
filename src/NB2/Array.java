package NB2;

public class Array {
    private int[] list;
    private int maxcapacity;
    private int nrOfElements;
    public Array(int initialCapacity) {
        maxcapacity = initialCapacity;
        nrOfElements = 0;
        list = new int[initialCapacity];
    }

    public boolean add(int element) {
        if(nrOfElements == maxcapacity) {
            reallocate();
        }
        list[nrOfElements] = element;
        nrOfElements++;
        return true;
    }

    public boolean add(int index, int element) {
        if(0 <= index && index < nrOfElements) {
            if (nrOfElements == maxcapacity) {
                reallocate();
            }
            for (int i = nrOfElements; i > index; i--) {
                list[i] = list[i-1];
            }
            list[index] = element;
            nrOfElements++;
            return true;
        }
        throw new IndexOutOfBoundsException("Index out of bounds " + index);
    }

    public int get(int index) {
        if(0<=index && index < nrOfElements) {
            return list[index];
        }
        throw new IndexOutOfBoundsException("Index out of bounds " + index);
    }

    public int indexOf(int element) {
        for (int i = 0; i < nrOfElements; i++) {
            if(list[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int index) {
        if(0 <= index && index < nrOfElements) {
            for (int i = index; i < nrOfElements; i++) {
                list[i] = list[i+1];
            }
            nrOfElements--;
            return true;
        }
        throw new IndexOutOfBoundsException("Index out of bounds  " + index);
    }

    public boolean set(int index, int element) {
        if (0 <= index && index < nrOfElements) {
            list[index] = element;
            return true;
        }
        throw new IndexOutOfBoundsException("Index out of bounds " + index);
    }

    public int size() {
        return nrOfElements;
    }

    private void reallocate() {
        int[] newArray = new int[maxcapacity * 2];
        for (int i = 0; i < nrOfElements; i++) {
            newArray[i] = list[i];
        }
        list = newArray;
    }

    public String toString() {
        String info = "";
        for (int i = 0; i < nrOfElements; i++) {
            info += "[" + list[i] + "]";
        }
        return info;
    }
}
