package F4.NB8;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class NB8_ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private int front, rear, size, maxSize;
    private E[] data;
    
    public NB8_ArrayQueue(int initialMaxSize) {
        size = 0;
        front = 0;
        maxSize = initialMaxSize;
        rear = maxSize-1;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element) {
        System.out.println(size);
        System.out.println(maxSize);
        if(size == maxSize) {
            reallocate();
        }if (size == maxSize / 4) {
            cutQueueInHalf();
        }
        rear = (rear+1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E peek() {
        if(size == 0) return null;
        return data[front];
    }

    public E poll() {
        if(size == 0) {
            return null;
        } else {
            size--;
            E element = data[front];
            front = (front+1) % maxSize;
            return element;
        }
    }
    private void cutQueueInHalf() {
        int newMaxSize = maxSize / 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }
    private void reallocate() {
        int newMaxSize = 2 * maxSize;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size -1;
        maxSize = newMaxSize;
        data = newData;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return size;

    }
    public String toString() {
        String info = "";
        for (int i = (front%maxSize); i < (size+front); i++) {
            info += "[" + data[i] + "]";
        }
        return info;
    }

    private class Iter implements Iterator<E> {
        private int index;
        private int count;
        public Iter() {
            index = front;
        }
        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

