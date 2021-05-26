package com.zhouhao;
//环形队列
public class Queue<V> {
    //数组模拟队列
    private final V[] arr;
    //队列头
    private int front;
    //队列尾
    private int rear;

    //队列长度
    private final int maxSize;
    //队列的无参构造器
    public Queue(){
        maxSize = 11;
        arr = (V[]) new Object[maxSize];
    }
    //队列的有参构造器
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize];
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }
    /**
     * 判断队列是否已满
     */
    public boolean isFull(){
        return (rear +1 + maxSize) % maxSize == front;
    }
    /**
     * 添加队列元素
     */
    public void add(V v){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear] = v;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 删除队列元素
     * @return
     */
    public V remove(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        V temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int size(){
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 遍历队列
     */
    public void list(){
        for (int i = front; i < front+size(); i++) {
            System.out.println(arr[i%maxSize]);
        }
    }
}
