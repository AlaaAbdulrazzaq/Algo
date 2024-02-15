package F3.NB5;

import java.util.EmptyStackException;
import java.util.Arrays;

public class NB5<E> implements NB5_interface<E>{

    private E[] data;
    private int top;
    private int maxSize;

    public NB5() {
        top = -1;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    @Override
    public E push(E obj) {
        if (top == maxSize-1) {
            reallocate();
        }
        top++;
        data[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void reallocate() {
        maxSize*=2;
        data=Arrays.copyOf(data,maxSize);
    }


}
