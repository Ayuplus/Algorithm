package com.zhouhao.arrayqueue02;

/**
 * 环形队列
 * 数组模拟队列优化版
 * @author
 */
public class Queue {
    /**
     *
     * @maxSize 环形队列长度 约定默认的队列长度为maxSize-1
     * @front 队列头 初始为0
     * @rear 队列尾  初始为0
     * @arr 数组模拟的环形队列
     */
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] arr;

    public Queue(int maxSize){
        //用构造器初始化环形队列
        this.maxSize = maxSize+1;
        arr = new int[this.maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        //当队列头与尾重合时,数组队列则为空
        return front == rear;
    }
    //判断队列是否已满
    public boolean isFull(){
        /**
         * maxSize保证结果不为负数
         * 假定 队列长5 队列尾指向2 队列头指向 1
         */
        return (rear+1+maxSize)%maxSize == front;
    }

    public void addElement(int num){
        if (isFull()){
            System.out.println("队列元素已满");
            return;
        }
        arr[rear] = num;
        System.out.println("存储成功");
        rear = (rear + 1) % maxSize;
    }
    public int getElement(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public int getHeadElement(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return arr[front];
    }
    public void listQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % maxSize]+"\t");
        }
        System.out.println();
    }

    public int size(){
        if (isEmpty()){
            return 0;
        }
        return (rear + maxSize - front)% maxSize;
    }

}
