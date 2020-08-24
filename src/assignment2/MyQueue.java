package assignment2;

import java.util.EmptyStackException;

/**
 * 
 * @author macbook
 */
public class MyQueue<T> {

    private int front, last, capacity;
    private T queue[];

    public MyQueue(int c) {
        front = last = 0;
        capacity = c + 1;
        queue = (T[]) new Object[capacity];

    }

    public boolean isEmpty() {
        if (front == last) {
            return true;
        }
        return false;
    }

    public void clear() {
        front = 0;
        last = 0;
        queue[last] = null;
    }

    public void enqueue(T data) {

        if ((last + 1) % capacity == front) {
            System.out.println("Queue is full");
        } else {
            queue[last] = data;
            last = (last + 1) % capacity;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T item = queue[front];
            front = (front + 1) % capacity;
            return item;
        }

    }

    public T first() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return queue[front];
    }

    public void traverse() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = front % capacity; i < last % capacity; i++) {
            System.out.println(queue[i]);
        }
    }

}
