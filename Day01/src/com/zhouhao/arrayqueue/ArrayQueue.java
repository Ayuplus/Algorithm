package com.zhouhao.arrayqueue;

/**
 * 数组队列
 * @author
 */
public class ArrayQueue {
    //队列初始化容量
    private final int maxSize;
    //队列前
    private int front;
    //队列后
    private int rear;
    //数组队列
    private final int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        //前后值相等时,判断为空
        return front == rear;
    }

    public boolean isFull(){
        //当rear达到maxSize-1时,队列满
        return rear == maxSize-1;
    }
    //队列加入元素
    public void addQueue(int num){
        //判断队列是否已满
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = num;
    }
    //队列取出元素
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }
    //遍历队列
    public void listQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }
    //获取队列的第一个元素
    public int getHeadElement(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
