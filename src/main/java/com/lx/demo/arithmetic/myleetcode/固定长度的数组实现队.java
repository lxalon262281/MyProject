package com.lx.demo.arithmetic.myleetcode;

public class 固定长度的数组实现队 {
    private int[] data;
    private int start;
    private int end;
    private int size;

    public 固定长度的数组实现队(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity should not be less than 0");
        data = new int[capacity];
        start = end = size = 0;
    }

    public void push(int obj) {
        if (size == data.length)
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        data[end] = obj;
        end = (end + 1) % data.length;
        size++;
    }

    public int poll() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        size--;
        int temp = data[start];
        start = (start + 1) % data.length;
        return temp;
    }

    public Integer peek() {
        if (size == 0)
            throw null;
        return data[start];
    }

    public static void main(String[] args) {
        固定长度的数组实现队 queue = new 固定长度的数组实现队(11);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        queue.push(10);
        queue.push(11);
        queue.push(12);
//        queue.push(13);
//        queue.push(14);
//        queue.push(15);
//        queue.push(16);

        System.out.println(queue.peek());

    }
}
