package com.zhouhao.arrayqueue;

/**
 * 数组队列
 * @author
 */
public class ArrayQueue {

    private int front;
    //队列容量
    private int maxSize;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public void addQueue(int num){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }

        front++;
        return arr[front];
    }

    public void listQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public int getHeadElement(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
