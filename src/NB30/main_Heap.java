package NB30;

public class main_Heap<E extends Comparable<E>> {
    private int size;
    private E[] data;
    private int nextpos;

    public main_Heap(int size) {
        this.size = size;
        data = (E[]) new Comparable[size];
        nextpos = 0;
    }

    public boolean insert(E data) {
        if (nextpos == size) {
            resize();
        }
        this.data[nextpos] = data;
        int current = nextpos;
        nextpos++;

        while (current > 0) {
            int parent = (current - 1) / 2;
            if (this.data[current].compareTo(this.data[parent]) < 0) {
                E tmp = this.data[current];
                this.data[current] = this.data[parent];
                this.data[parent] = tmp;

                current = parent;
            } else {
                break;
            }
        }
        return true;
    }

    private void resize() {
        size = size * 2;
        E[] newArray = (E[]) new Comparable[size];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    public E extract() {
        if (nextpos == 0) {
            return null;
        }
        E removedItem = this.data[0];
        this.data[0] = this.data[nextpos-1];
        nextpos--;

        int current = 0;
        while (current < nextpos) {
            int leftChild = (2*current) + 1;
            int rightChild = (2*current) + 2;
            int smallest = current;

            if (leftChild < nextpos && data[leftChild].compareTo(data[smallest]) < 0) {
                smallest = leftChild;
            }
            if (rightChild < nextpos && data[rightChild].compareTo(data[smallest]) < 0) {
                smallest = rightChild;
            }

            if (smallest != current) {
                E tmp = data[current];
                data[current] = data[smallest];
                data[smallest] = tmp;

                current = smallest;
            } else
                break;
        }
        return removedItem;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E item : data) {
            sb.append(item + " ");
        }
        return sb.toString();
    }
}
