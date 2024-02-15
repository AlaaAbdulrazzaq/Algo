package NB0;

public class NBo<E> {
    private E[] data;
    private int nrOfElements;
    private int capacity;

    public NBo(int maxCapacity) {
        nrOfElements = 0;
        capacity = maxCapacity;
        data = (E[]) new Object[capacity];
    }
    public NBo() {
        nrOfElements = 0;
        capacity = 10;
        data = (E[]) new Object[capacity];
    }

    public boolean add(E newObject) {
        if(nrOfElements == capacity) {
            resize();
        }
        this.data[nrOfElements] = newObject;
        nrOfElements++;
        return true;
    }

    public E get(int index) {
        if(0 <= index && index < nrOfElements){
            return this.data[index];
        }
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    public void add(int index, E object) {
        if(0 <= index && index <= nrOfElements) {
            if (nrOfElements == capacity) {
                resize();
            }
            for (int i = nrOfElements; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = object;
            nrOfElements++;
        }
    }
    
    public E set(int index, E object) {
        E replacedElement = null;
        if(0 <= index && index <= nrOfElements) {
            if (nrOfElements == capacity) {
                resize();
            }
            replacedElement = data[index];
            data[index] = object;
        }
        return replacedElement;
    }

    public int indexOf(E elementToFind) {
        for(int i = 0; i < nrOfElements; i++){
            if(data[i].equals(elementToFind)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int index) {
        if(0 <= index && index <= nrOfElements) {
            for (int i = index; i < nrOfElements; i++) {
                data[i] = data[i+1];
            }
            nrOfElements--;
            return true;
        }
        return false;
    }

    private void resize() {
        capacity*=2;
        E[] newList = (E[]) new Object[capacity];
        for (int i = 0; i < nrOfElements; i++) {
            newList[i] = this.data[i];
        }
        this.data = newList;
    }

    public String toString() {
        String info = "";
        for (int i = 0; i < nrOfElements; i++) {
            info += "[" + data[i] + "]";
        }
        return info;
    }
}
