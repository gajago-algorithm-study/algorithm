package week3rd;

import java.util.Arrays;

public class DesignCircularQueue {
    static class MyCircularQueue {
        private int[] queue;
        private int capacity;
        private int front;
        private int rear;

        public MyCircularQueue(int k) {
            capacity = k;
            queue = new int[capacity];
            front = -1;
            rear = -1;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;

            if (isEmpty())
                front = 0;
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            if (front == rear)
                front = rear = -1;
            else
                front = (front + 1) % capacity;

            return true;
        }

        public int Front() {
            if (isEmpty())
                return -1;
            return queue[front];
        }

        public int Rear() {
            if (isEmpty())
                return -1;
            return queue[rear];
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return front == (rear + 1) % capacity;
        }

        public void printQueue() {
            System.out.println("front: " + front);
            System.out.println("rear: " + rear);
            System.out.println(Arrays.toString(queue));
        }
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean b1 = obj.enQueue(1);
        System.out.println("b1 = " + b1);
        boolean b2 = obj.enQueue(2);
        System.out.println("b2 = " + b2);
        boolean b3 = obj.enQueue(3);
        System.out.println("b3 = " + b3);
        boolean b4 = obj.enQueue(4);
        System.out.println("b4 = " + b4);

        int rear = obj.Rear();
        System.out.println("rear = " + rear);
        boolean full = obj.isFull();
        System.out.println("full = " + full);
        boolean b = obj.deQueue();
        System.out.println("b = " + b);
        boolean b5 = obj.enQueue(4);
        System.out.println("b5 = " + b5);
        int rear1 = obj.Rear();
        System.out.println("rear1 = " + rear1);
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.enQueue(11);
        obj.enQueue(22);
        obj.enQueue(33);
        obj.printQueue();
    }
}
